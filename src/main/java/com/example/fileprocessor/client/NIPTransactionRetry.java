package com.example.fileprocessor.client;

import com.example.fileprocessor.dto.CPInformation;
import com.example.fileprocessor.dto.ChannelPartner;
import com.example.fileprocessor.dto.ChannelPartnerUpdateRequest;
import com.example.fileprocessor.dto.ChannelPartnerUpdateResponse;
import com.example.fileprocessor.dto.TransactionDetailsDto;
import com.example.fileprocessor.reader.IdReaderDto;
import com.example.fileprocessor.reader.MyFileReader;
import com.example.fileprocessor.reader.ceva.NIPTransactionInformationDto;
import com.example.fileprocessor.reader.ceva.out.AccountDetailsInformation;
import com.example.fileprocessor.reader.ceva.out.AccountInformation;
import com.example.fileprocessor.reader.ceva.out.CustomerParams;
import com.example.fileprocessor.reader.ceva.out.Meta;
import com.example.fileprocessor.reader.ceva.out.NIPRetryDto;
import com.example.fileprocessor.reader.ceva.out.PayeeInformation;
import com.example.fileprocessor.reader.ceva.out.PayerInformation;
import com.example.fileprocessor.reader.ceva.out.TransactionAmount;
import com.example.fileprocessor.reader.ceva.out.TransactionInfo;
import com.example.fileprocessor.reader.staff.StaffInputDto;
import com.example.fileprocessor.reader.staff.StaffUpgradeProcessResponseDto;
import com.example.fileprocessor.reader.staff.StaffUpgradeResponseDto;
import com.example.fileprocessor.reader.staff.out.InputParameters;
import com.example.fileprocessor.reader.staff.out.StaffUpgradeProcess;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.Document;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Slf4j
public class NIPTransactionRetry {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MyFileReader myFileReader;

    private String buildDateField(String field) {
        if(field.length() < 2) {
            return "0" + field;
        }

        return field;
    }
    private NIPRetryDto buildNipRetryDto(String inputRequest){
        DocumentContext dc = JsonPath.parse(inputRequest);


        String channel = dc.read("$.pspTransactionRequest.meta.channel");
        String sessId = dc.read("$.pspTransactionRequest.meta.nipSessionId");
        //
        Meta meta = new Meta(channel, sessId);
        //

        String td = dc.read("$.pspTransactionRequest.txn.td");
        String ts = dc.read("$.pspTransactionRequest.txn.ts").toString();
        ts = ts.substring(1, ts.length() -1);
//        "ts": "2023-07-08T17:54:28"
        String[] splitStr= ts.split(",");
        ts = buildDateField(splitStr[0])+"-" + buildDateField(splitStr[1]) +"-" + buildDateField(splitStr[2]) +"T"+ buildDateField(splitStr[3]) +":" + buildDateField(splitStr[4]);
        if(splitStr.length == 6) {
            ts += ":" + buildDateField(splitStr[5]);
        }else {
            ts += ":00";
        }
        String note = dc.read("$.pspTransactionRequest.txn.note");
        String txnType = dc.read("$.pspTransactionRequest.txn.txnType");
        String externalId = dc.read("$.pspTransactionRequest.txn.externalId") + "_";
        String countryCode = dc.read("$.pspTransactionRequest.txn.countryCode");

        //
        TransactionInfo transactionInfo = new TransactionInfo(externalId, txnType, note, countryCode, td, ts);
        //
        Integer total = dc.read("$.pspTransactionRequest.payer.txnAmount.total");
        String currency = dc.read("$.pspTransactionRequest.payer.txnAmount.currency");
        //
        TransactionAmount transactionAmount = new TransactionAmount(currency, total);
        //
        String bvn = dc.read("$.pspTransactionRequest.payer.customerParams.bvn");
        String kycLevel = dc.read("$.pspTransactionRequest.payer.customerParams.kycLevel");
        String accountNo = dc.read("$.pspTransactionRequest.payer.customerParams.accountNo");
        String accountName = dc.read("$.pspTransactionRequest.payer.customerParams.accountName");
        String txnLocation = dc.read("$.pspTransactionRequest.payer.customerParams.txnLocation");
        String paymentRefNo = dc.read("$.pspTransactionRequest.payer.customerParams.paymentRefNo");

        //
        CustomerParams customerParams = new CustomerParams(accountNo, accountName, kycLevel, bvn, txnLocation, paymentRefNo);
        //

        String name = dc.read("$.pspTransactionRequest.payer.name");
        String type = dc.read("$.pspTransactionRequest.payer.type");
        String code = dc.read("$.pspTransactionRequest.payer.code");
        String countryCodePayer = dc.read("$.pspTransactionRequest.payer.countryCode");
        String payAddrType = dc.read("$.pspTransactionRequest.payer.payAddrType");
        String payAddress = dc.read("$.pspTransactionRequest.payer.payAddress");
        //
        PayerInformation payerInformation = new PayerInformation(name, type, code, countryCodePayer, payAddrType, payAddress, transactionAmount, customerParams);
        //

        String payeeType = dc.read("$.pspTransactionRequest.payee.type");
        String payeeCode = dc.read("$.pspTransactionRequest.payee.code");
        String addrType = dc.read("$.pspTransactionRequest.payee.account.addrType");
        String msisdn = dc.read("$.pspTransactionRequest.payee.account.details.msisdn");
        String wallet = dc.read("$.pspTransactionRequest.payee.account.details.wallet");


        AccountDetailsInformation accountDetailsInformation = new AccountDetailsInformation(msisdn, wallet);
        AccountInformation accountInformation = new AccountInformation(addrType, accountDetailsInformation);
        PayeeInformation payeeInformation = new PayeeInformation(payeeType, payeeCode, accountInformation, countryCode);

        NIPRetryDto nipRetryDto = new NIPRetryDto(meta, transactionInfo, payerInformation, payeeInformation);

        return nipRetryDto;
    }

    public void callBackendServer(NIPTransactionInformationDto nipTransactionInformationDto){

        try{
            NIPRetryDto nipRetryDto = buildNipRetryDto(nipTransactionInformationDto.getIncomingRequest());

            String url = "https://apps.ng.prod.psb.k8s.africa.airtel.itm/arch-in/web/apc/txn/process";
            HttpHeaders headers = new HttpHeaders();
            headers.add("asp-opco", "NG");
            headers.add("Content-Type", "application/json");
            headers.add("x-channel-name", "gsm-esb");
            headers.add("x-service-id", "integration_gsm_esb_web");
            headers.add("x-app-version", "1.0.0");

            HttpEntity<NIPRetryDto> httpEntity = new HttpEntity<>(nipRetryDto, headers);

            RestTemplate restTemplate = new RestTemplate(new CustomClientHttpRequestFactory(50000, 50000, true));

                ResponseEntity<TransactionDetailsDto> cp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, TransactionDetailsDto.class);

                if(cp.getBody().getSt()) {
//                System.out.println(
//                        "Success: SessionId: " + nipRetryDto.getMeta().getNipSessionId()
//                                + " ,msdId:" + cp.getBody().getMsgid()
//                                + " ,message " + cp.getBody().getMsg()
//                                + " ,status " + cp.getBody().getData().getStatus()
//                                + " ,state " + cp.getBody().getData().getState()
//
//                                + " ,transactionId: " + cp.getBody().getData().getTransactionId()
//                                + " ,externalId: " + cp.getBody().getData().getExternalId()
//
//                );
            }else {
                System.out.println(
                        "Failure: ExternalId: " + nipRetryDto.getTxn().getExternalId()
                                + " ,msdId:" + cp.getBody().getMsgid()
                                + " ,message " + cp.getBody().getMsg()
                );
            }
        }catch(Exception ex) {
            System.out.println("Exception occurred processing " + nipTransactionInformationDto);
        }
    }
}
