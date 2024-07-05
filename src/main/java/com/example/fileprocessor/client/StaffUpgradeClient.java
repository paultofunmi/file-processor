package com.example.fileprocessor.client;

import com.example.fileprocessor.reader.MyFileReader;
import com.example.fileprocessor.reader.staff.StaffInputDto;
import com.example.fileprocessor.reader.staff.StaffUpgradeResponseDto;
import com.example.fileprocessor.reader.staff.out.InputParameters;
import com.example.fileprocessor.reader.staff.out.StaffUpgradeProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class StaffUpgradeClient {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MyFileReader myFileReader;

    public String callBackendStaffUpgrade(StaffInputDto staffInputDto){
        StaffUpgradeProcess staffUpgradeProcess = new StaffUpgradeProcess();
        staffUpgradeProcess.setProcessName("airtel_staff_upgrade_wallet_account_v1");
        staffUpgradeProcess.setTaskName("CustomerInfo4FormFieldValidateAndSubmit");
        InputParameters inputParameters = getInputParameters(staffInputDto);

        staffUpgradeProcess.setInputParameters(inputParameters);

        return sendStaffUpgradeRequest(staffUpgradeProcess);
    }

    private String sendStaffUpgradeRequest(StaffUpgradeProcess staffUpgradeProcess) {
        String url = "https://apps.ng.prod.psb.k8s.africa.airtel.itm/kong/collective/rest/data/onboarding/v1/startProcess";
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Api-Client", "G8HMqxq7d6");
        headers.add("Content-Type", "application/json");
        headers.add("ASP-API-Key", "58232f0e-2202-46e8-a159-af5e99287d58");

        HttpEntity<StaffUpgradeProcess> httpEntity = new HttpEntity<>(staffUpgradeProcess, headers);

        RestTemplate restTemplate = new RestTemplate(new CustomClientHttpRequestFactory(50000, 50000, true));
        String res = "";
        try{
            ResponseEntity<StaffUpgradeResponseDto> cp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, StaffUpgradeResponseDto.class);

            res = "Message: " + cp.getBody().getMsg()
                    + " ,msdId:" + cp.getBody().getMsgid()
                    + " ,Id: " + cp.getBody().getProcessResponse().getApplicationId()
                    + " ,process: " + cp.getBody().getProcessResponse().getProcessName()
                    + " ,Reason: " + cp.getBody().getProcessResponse().getFailureReason();

            if(cp.getBody().getSt()) {
                res = "Success: " + res;
                System.out.println(res);
            }else {
                res = "Failure:" + res;
                System.out.println(res);
            }
        }catch(Exception ex) {
            System.out.println("Exception occurred processing " + staffUpgradeProcess);
            res = "Failure: " + ex.toString();
        }

        return res;
    }

    private static InputParameters getInputParameters(StaffInputDto staffInputDto) {
        InputParameters inputParameters = new InputParameters();
        inputParameters.setMsisdn(staffInputDto.getMsisdn());
        inputParameters.setPrimaryIdType("NIN");
        inputParameters.setPrimaryIdNumber(staffInputDto.getNin());
        inputParameters.setSecondaryIdType("BVN");
        inputParameters.setSecondaryIdNumber(staffInputDto.getBvn());
        inputParameters.setKinFirstName("Roland");
        inputParameters.setKinLastName("Ogbonda");
        inputParameters.setKinMsisdn("8022220797");
        return inputParameters;
    }
}
