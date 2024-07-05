package com.example.fileprocessor.dto;

import lombok.Data;

//@Data
public class ChannelPartnerUpdateResponse {

    private String status;
    private String message;

    private CPUpdateUpdateInformation response;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CPUpdateUpdateInformation getResponse() {
        return response;
    }

    public void setResponse(CPUpdateUpdateInformation response) {
        this.response = response;
    }
}