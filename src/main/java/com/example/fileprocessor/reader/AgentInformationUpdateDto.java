package com.example.fileprocessor.reader;

import com.opencsv.bean.CsvBindByPosition;

//@Data
public class AgentInformationUpdateDto {

    @CsvBindByPosition(position = 0)
    private String msisdn;

    @CsvBindByPosition(position = 1)
    private String dob;

    @CsvBindByPosition(position = 2)
    private String idNo;

    @CsvBindByPosition(position = 3)
    private String gender;

    @CsvBindByPosition(position = 4)
    private String idType;

    @CsvBindByPosition(position = 5)
    private String msisdn1;

    @CsvBindByPosition(position = 6)
    private String address1;

    @CsvBindByPosition(position = 7)
    private String address2;

    @CsvBindByPosition(position = 8)
    private String city;

    @CsvBindByPosition(position = 9)
    private String state;

    @CsvBindByPosition(position = 10)
    private String country;

    @CsvBindByPosition(position = 11)
    private String region;

    @CsvBindByPosition(position = 12)
    private String lastName;

    @CsvBindByPosition(position = 13)
    private String firstName;

    @CsvBindByPosition(position = 14)
    private String division;

    @CsvBindByPosition(position = 15)
    private String categoryCode;


    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getMsisdn1() {
        return msisdn1;
    }

    public void setMsisdn1(String msisdn1) {
        this.msisdn1 = msisdn1;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}

//    MSISDN,DOB,ID_NO,GENDER,ID_TYPE,MSISDN,ADDRESS1,ADDRESS2,CITY,STATE,
//    COUNTRY,REGION,LAST_NAME,FIRST_NAME,DIVISION,CATEGORY_CODE