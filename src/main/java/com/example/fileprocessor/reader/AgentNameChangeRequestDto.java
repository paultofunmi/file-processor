package com.example.fileprocessor.reader;

import com.opencsv.bean.CsvBindByPosition;

public class AgentNameChangeRequestDto {

    @CsvBindByPosition(position = 0)
    private String msisdn;

    @CsvBindByPosition(position = 1)
    private String userGrade;

    @CsvBindByPosition(position = 2)
    private String userName;

    @CsvBindByPosition(position = 3)
    private String lastName;

    @CsvBindByPosition(position = 4)
    private String dob;

    @CsvBindByPosition(position = 5)
    private String status;

    @CsvBindByPosition(position = 6)
    private String createdOn;

    @CsvBindByPosition(position = 7)
    private String address1;

    @CsvBindByPosition(position = 8)
    private String address2;

    @CsvBindByPosition(position = 9)
    private String agentCode;

    @CsvBindByPosition(position = 10)
    private String IdNo;

    @CsvBindByPosition(position = 11)
    private String idType;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getIdNo() {
        return IdNo;
    }

    public void setIdNo(String idNo) {
        IdNo = idNo;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }
}