package com.example.fileprocessor.reader.staff;

import com.opencsv.bean.CsvBindByPosition;

public class StaffInputDto {

    @CsvBindByPosition(position = 0)
    private String msisdn;

    @CsvBindByPosition(position = 1)
    private String bvn;

    @CsvBindByPosition(position = 2)
    private String nin;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getBvn() {
        return bvn;
    }

    public void setBvn(String bvn) {
        this.bvn = bvn;
    }
}