package com.example.fileprocessor.reader.ceva.out;


import lombok.Data;

@Data
public class PayeeInformation {

    private String type;
    private String code;

    private AccountInformation account;
    private String countryCode;

    public PayeeInformation(String type, String code, AccountInformation account, String countryCode) {
        this.type = type;
        this.code = code;
        this.account = account;
        this.countryCode = countryCode;
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

    public AccountInformation getAccount() {
        return account;
    }

    public void setAccount(AccountInformation account) {
        this.account = account;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
