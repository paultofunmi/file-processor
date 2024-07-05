package com.example.fileprocessor.dto;

public class TransactionDetailsDataDto {

    private String status;

    private String state;

    private String transactionId;

    private String externalId;

    public TransactionDetailsDataDto() {}

    public TransactionDetailsDataDto(String status, String state, String transactionId, String externalId) {
        this.status = status;
        this.state = state;
        this.transactionId = transactionId;
        this.externalId = externalId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @Override
    public String toString() {
        return "TransactionDetailsDataDto{" +
                "status='" + status + '\'' +
                ", state='" + state + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", externalId='" + externalId + '\'' +
                '}';
    }
}
