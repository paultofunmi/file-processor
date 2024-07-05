package com.example.fileprocessor.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ChannelPartner {

    private String status;
    private String message;

    private CPInformation response;

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

    public CPInformation getResponse() {
        return response;
    }

    public void setResponse(CPInformation response) {
        this.response = response;
    }
}