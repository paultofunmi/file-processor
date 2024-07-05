package com.example.fileprocessor.reader.ceva.out;


import lombok.Data;

@Data
public class AccountDetailsInformation {

    private String msisdn;
    private String wallet;

    public AccountDetailsInformation(String msisdn, String wallet) {
        this.msisdn = msisdn;
        this.wallet = wallet;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }
}
