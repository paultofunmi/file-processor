package com.example.fileprocessor.reader.ceva.out;


import lombok.Data;

@Data
public class PayerInformation {

    private String name;
    private String type;
    private String code;
    private String countryCode;
    private String payAddrType;
    private String payAddress;

    private TransactionAmount txnAmount;

    private CustomerParams customerParams;

    public PayerInformation(String name, String type, String code, String countryCode, String payAddrType, String payAddress, TransactionAmount txnAmount, CustomerParams customerParams) {
        this.name = name;
        this.type = type;
        this.code = code;
        this.countryCode = countryCode;
        this.payAddrType = payAddrType;
        this.payAddress = payAddress;
        this.txnAmount = txnAmount;
        this.customerParams = customerParams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPayAddrType() {
        return payAddrType;
    }

    public void setPayAddrType(String payAddrType) {
        this.payAddrType = payAddrType;
    }

    public String getPayAddress() {
        return payAddress;
    }

    public void setPayAddress(String payAddress) {
        this.payAddress = payAddress;
    }

    public TransactionAmount getTxnAmount() {
        return txnAmount;
    }

    public void setTxnAmount(TransactionAmount txnAmount) {
        this.txnAmount = txnAmount;
    }

    public CustomerParams getCustomerParams() {
        return customerParams;
    }

    public void setCustomerParams(CustomerParams customerParams) {
        this.customerParams = customerParams;
    }
}
