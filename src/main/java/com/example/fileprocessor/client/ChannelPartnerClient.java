//package com.example.fileprocessor.client;
//
//import com.example.fileprocessor.dto.CPInformation;
//import com.example.fileprocessor.dto.ChannelPartner;
//import com.example.fileprocessor.dto.ChannelPartnerUpdateRequest;
//import com.example.fileprocessor.dto.ChannelPartnerUpdateResponse;
//import com.example.fileprocessor.reader.MyFileReader;
//import com.example.fileprocessor.reader.ShopInformation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//@Component
//@Slf4j
//public class ChannelPartnerClient {
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    @Autowired
//    MyFileReader myFileReader;
//
//    public void callCP(ShopInformation shopInformation){
//        String url = "http://172.24.30.29:30001/api/am-profile/v1/channelpartner/kyc";
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("asp-opco", "NG");
//        headers.add("Content-Type", "application/json");
//        headers.add("x-channelpartner-type", "CANVASSER");
//        headers.add("x-service-id", "integration_clm_web");
//        headers.add("X-CLIENT-ID", "KYC_BE");
//
//        Map<String, String> body = new HashMap<>();
//        body.put("msisdn",shopInformation.getMsisdn());
//        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);
//
//        ResponseEntity<ChannelPartner> cp = restTemplate.exchange(url, HttpMethod.POST, entity, ChannelPartner.class);
//
//        processResponse(cp.getBody(), shopInformation);
//    }
//
//    private void processResponse(ChannelPartner cp, ShopInformation shopInformation) {
//        if(cp.getStatus().equalsIgnoreCase("200")) {
//            CPInformation cp1 = cp.getResponse();
//
//            String dob1 = cp1.getDob().split(" ")[0];
//            String[] splitDob = dob1.split("-");
//            ChannelPartnerUpdateRequest cpRequest = new ChannelPartnerUpdateRequest();
//
//            String[] splitShopName = shopInformation.getName().split(" ");
//            String lastName = splitShopName[splitShopName.length - 1];
//            String firstName = "";
//            for(int i = 0 ; i < splitShopName.length - 1; i++) {
//                firstName += " " + splitShopName[i];
//            }
//
//            String url = "http://172.24.30.29:30001/api/am-profile/v1/channelpartner/salesAgentUpdate";
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("asp-opco", "NG");
//            headers.add("Content-Type", "application/json");
////            headers.add("x-channelpartner-type", "CANVASSER");
//            headers.add("x-service-id", "integration_leap_web");
//            headers.add("X-CLIENT-ID", "leap");
//
//            cpRequest.setDob(splitDob[2]+splitDob[1]+splitDob[0]);
//            cpRequest.setIdNo(cp1.getIdno());
//            cpRequest.setGender("MALE");
//            cpRequest.setIdType("CLM");
////            cpRequest.setIdType("CLM ID FOR TIER1");
//            cpRequest.setMsisdn(shopInformation.getMsisdn());
//            cpRequest.setAddress1(shopInformation.getAddress());
//            cpRequest.setAddress2("NA");
//            cpRequest.setCity("NA");
//            cpRequest.setState("state");
//            cpRequest.setCountry("Nigeria");
//            cpRequest.setRegion(shopInformation.getRegion());
//            cpRequest.setLastName(lastName);
//            cpRequest.setMiddleName("");
//            cpRequest.setNickname(cp1.getNickname());
//            cpRequest.setFirstName(firstName.trim());
//            cpRequest.setGradeCode(cp1.getGrade());
//            cpRequest.setExtTrId(UUID.randomUUID().toString());
//            cpRequest.setDivision("DIVISION");
//            cpRequest.setCategoryCode(cp1.getUserGrade());
//            cpRequest.setRegTypeId("COM_"+cp1.getGrade());
//
//            Map<String, String> body = new HashMap<>();
//
//            body.put("dob", cpRequest.getDob());
//            body.put("idNo", cpRequest.getIdNo());
//            body.put("gender", cpRequest.getGender());
//            body.put("idType", cpRequest.getIdType());
//            body.put("msisdn", cpRequest.getMsisdn());
//            body.put("address1", cpRequest.getAddress1());
//            body.put("address2", cpRequest.getAddress2());
//            body.put("city", cpRequest.getCity());
//            body.put("state", cpRequest.getState());
//            body.put("country", cpRequest.getCountry());
//            body.put("region", cpRequest.getRegion());
//            body.put("lastName", cpRequest.getLastName());
//            body.put("middleName", cpRequest.getMiddleName());
//            body.put("nickname", cpRequest.getNickname());
//            body.put("firstName", cpRequest.getFirstName());
//            body.put("gradeCode", cpRequest.getGradeCode());
//            body.put("extTrId", cpRequest.getExtTrId());
//            body.put("division", cpRequest.getDivision());
//            body.put("categoryCode", cpRequest.getCategoryCode());
//            body.put("regTypeId", cpRequest.getRegTypeId());
//
//            HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);
//
//            ResponseEntity<ChannelPartnerUpdateResponse> updateResp = restTemplate.exchange(url, HttpMethod.POST, entity, ChannelPartnerUpdateResponse.class);
//
//            if(updateResp.getBody().getStatus().equalsIgnoreCase("200")) {
//                log.info("Updated Wallet Information for msisdn - {}", shopInformation.getMsisdn());
//            }else {
//                log.info("MQ Error while updating msisdn - {} with error - {}", shopInformation.getMsisdn(), updateResp);
//            }
//
//        }else {
//            log.info("No record found for msisdn - {}", shopInformation.getMsisdn());
//        }
//    }
//}
