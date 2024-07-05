package com.example.fileprocessor.reader.ceva.out;


import lombok.Data;

@Data
public class CustomerParams {

    private String accountNo ;
    private String accountName;
    private String kycLevel;
    private String bvn;
    private String txnLocation;
    private String paymentRefNo;

    public CustomerParams(String accountNo, String accountName, String kycLevel, String bvn, String txnLocation, String paymentRefNo) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.kycLevel = kycLevel;
        this.bvn = bvn;
        this.txnLocation = txnLocation;
        this.paymentRefNo = paymentRefNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getKycLevel() {
        return kycLevel;
    }

    public void setKycLevel(String kycLevel) {
        this.kycLevel = kycLevel;
    }

    public String getBvn() {
        return bvn;
    }

    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    public String getTxnLocation() {
        return txnLocation;
    }

    public void setTxnLocation(String txnLocation) {
        this.txnLocation = txnLocation;
    }

    public String getPaymentRefNo() {
        return paymentRefNo;
    }

    public void setPaymentRefNo(String paymentRefNo) {
        this.paymentRefNo = paymentRefNo;
    }
}
