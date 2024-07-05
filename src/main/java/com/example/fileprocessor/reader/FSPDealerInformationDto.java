package com.example.fileprocessor.reader;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

public class FSPDealerInformationDto {

    @CsvBindByPosition(position = 0)
    private String msisdn;

    @CsvBindByPosition(position = 1)
    private String userGrade;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }
}