package com.example.fileprocessor.reader.ceva.out;

import lombok.Data;

@Data
public class AccountInformation {

    private String addrType;

    private AccountDetailsInformation details;

    public AccountInformation(String addrType, AccountDetailsInformation details) {
        this.addrType = addrType;
        this.details = details;
    }

    public String getAddrType() {
        return addrType;
    }

    public void setAddrType(String addrType) {
        this.addrType = addrType;
    }

    public AccountDetailsInformation getDetails() {
        return details;
    }

    public void setDetails(AccountDetailsInformation details) {
        this.details = details;
    }
}
