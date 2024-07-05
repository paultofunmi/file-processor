package com.example.fileprocessor.client;

import com.example.fileprocessor.dto.CPInformation;
import com.example.fileprocessor.dto.ChannelPartner;
import com.example.fileprocessor.dto.ChannelPartnerUpdateRequest;
import com.example.fileprocessor.dto.ChannelPartnerUpdateResponse;
import com.example.fileprocessor.reader.AgentInformationUpdateDto;
import com.example.fileprocessor.reader.IdReaderDto;
import com.example.fileprocessor.reader.MyFileReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Slf4j
public class AgentUpdateClient {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MyFileReader myFileReader;

    public void callCP(IdReaderDto idReaderDto){
        String url = "http://172.24.30.29:30001/api/am-profile/v1/channelpartner/kyc";
        HttpHeaders headers = new HttpHeaders();
        headers.add("asp-opco", "NG");
        headers.add("Content-Type", "application/json");
        headers.add("x-channelpartner-type", "CANVASSER");
        headers.add("x-service-id", "integration_clm_web");
        headers.add("X-CLIENT-ID", "KYC_BE");

        Map<String, String> body = new HashMap<>();
        body.put("msisdn", idReaderDto.id);
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<ChannelPartner> cp = restTemplate.exchange(url, HttpMethod.POST, entity, ChannelPartner.class);

        processResponse(cp.getBody(), idReaderDto);
    }

    private void processResponse(
            ChannelPartner cp,
            IdReaderDto idReaderDto
    ) {
        if(cp.getStatus().equalsIgnoreCase("200")) {
            CPInformation cp1 = cp.getResponse();

            String dob1 = cp1.getDob().split(" ")[0];
            //1991-06-07 16:57:23.0
            String[] splitDob = dob1.split("-");
            ChannelPartnerUpdateRequest cpRequest = new ChannelPartnerUpdateRequest();

            String gender = cp1.getAdditionaldata().split(",")[3];
//            String[] splitShopName = agentInformation.getName().split(" ");
//            String lastName = splitShopName[splitShopName.length - 1];
//            String firstName = "";
//            for(int i = 0 ; i < splitShopName.length - 1; i++) {
//                firstName += " " + splitShopName[i];
//            }

            String url = "http://172.24.30.29:30001/api/am-profile/v1/channelpartner/salesAgentUpdate";
            HttpHeaders headers = new HttpHeaders();
            headers.add("asp-opco", "NG");
            headers.add("Content-Type", "application/json");
//            headers.add("x-channelpartner-type", "CANVASSER");
            headers.add("x-service-id", "integration_leap_web");
            headers.add("X-CLIENT-ID", "leap");

            cpRequest.setDob(splitDob[2]+splitDob[1]+splitDob[0]); //07061991
            cpRequest.setIdNo(cp1.getIdno());
            cpRequest.setGender(gender.toUpperCase().trim());
            cpRequest.setIdType(cp1.getIdtype());
            cpRequest.setMsisdn(idReaderDto.id);
            cpRequest.setAddress1("NA");
            cpRequest.setAddress2("NA");
            cpRequest.setCity("NA");
            cpRequest.setState("state");
            cpRequest.setCountry("Nigeria");
            cpRequest.setRegion("NA");
            cpRequest.setLastName(cp1.getLastname());
            cpRequest.setMiddleName("");
            cpRequest.setNickname(cp1.getNickname());
            cpRequest.setFirstName(cp1.getFirstname());
            cpRequest.setExtTrId(UUID.randomUUID().toString());
            cpRequest.setGradeCode("akycagnt");
            cpRequest.setDivision("DIVISION");
            cpRequest.setCategoryCode("RT");
            cpRequest.setRegTypeId("COM_"+"akycagnt");

            Map<String, String> body = new HashMap<>();

            body.put("dob", cpRequest.getDob());
            body.put("idNo", cpRequest.getIdNo());
            body.put("gender", cpRequest.getGender());
            body.put("idType", getIdType(cpRequest.getIdType()));
            body.put("msisdn", cpRequest.getMsisdn());
            body.put("address1", cpRequest.getAddress1());
            body.put("address2", cpRequest.getAddress2());
            body.put("city", cpRequest.getCity());
            body.put("state", cpRequest.getState());
            body.put("country", cpRequest.getCountry());
            body.put("region", cpRequest.getRegion());
            body.put("lastName", cpRequest.getLastName());
            body.put("middleName", cpRequest.getMiddleName());
            body.put("nickname", cpRequest.getNickname());
            body.put("firstName", cpRequest.getFirstName());
            body.put("gradeCode", cpRequest.getGradeCode());
            body.put("extTrId", cpRequest.getExtTrId());
            body.put("division", cpRequest.getDivision());
            body.put("categoryCode", cpRequest.getCategoryCode());
            body.put("regTypeId", cpRequest.getRegTypeId());
//            body.put("parentMsisdn", agentInformation.getParentMsisdn());

            HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);


            ResponseEntity<ChannelPartnerUpdateResponse> updateResp = restTemplate.exchange(url, HttpMethod.POST, entity, ChannelPartnerUpdateResponse.class);

//            if(updateResp.getBody().getStatus().equalsIgnoreCase("200")) {
//                System.out.println("Updated Wallet Information for msisdn - {}" + idReaderDto.id);
//            }else {
//                System.out.println("MQ Error while updating msisdn - {} with error - {}" + idReaderDto.id + updateResp);
//            }

        }else {
            System.out.println("No record found for msisdn - {}" + idReaderDto.id);
        }
    }

    private String getIdType(String idType) {
//        if(idType.contains("BVN")) return "BVN";
//        else if (idType.contains("CLM")) return "CLM";
//        else if (idType.contains("NIN")) return "NIN";
        if (idType.contains("Nigeria Identification Number")) return "NIN";
        else return idType;
    }
}
