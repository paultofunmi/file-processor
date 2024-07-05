package com.example.fileprocessor.reader.staff.out;

public class InputParameters {

    private String msisdn;
    private String primaryIdType;
    private String primaryIdNumber;
    private String secondaryIdType;

    private String secondaryIdNumber;

    private String kinFirstName;
    private String kinLastName;
    private String kinMsisdn;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getPrimaryIdType() {
        return primaryIdType;
    }

    public void setPrimaryIdType(String primaryIdType) {
        this.primaryIdType = primaryIdType;
    }

    public String getPrimaryIdNumber() {
        return primaryIdNumber;
    }

    public void setPrimaryIdNumber(String primaryIdNumber) {
        this.primaryIdNumber = primaryIdNumber;
    }

    public String getSecondaryIdType() {
        return secondaryIdType;
    }

    public void setSecondaryIdType(String secondaryIdType) {
        this.secondaryIdType = secondaryIdType;
    }

    public String getSecondaryIdNumber() {
        return secondaryIdNumber;
    }

    public void setSecondaryIdNumber(String secondaryIdNumber) {
        this.secondaryIdNumber = secondaryIdNumber;
    }

    public String getKinFirstName() {
        return kinFirstName;
    }

    public void setKinFirstName(String kinFirstName) {
        this.kinFirstName = kinFirstName;
    }

    public String getKinLastName() {
        return kinLastName;
    }

    public void setKinLastName(String kinLastName) {
        this.kinLastName = kinLastName;
    }

    public String getKinMsisdn() {
        return kinMsisdn;
    }

    public void setKinMsisdn(String kinMsisdn) {
        this.kinMsisdn = kinMsisdn;
    }

    @Override
    public String toString() {
        return "InputParameters{" +
                "msisdn='" + msisdn + '\'' +
                ", primaryIdType='" + primaryIdType + '\'' +
                ", primaryIdNumber='" + primaryIdNumber + '\'' +
                ", secondaryIdType='" + secondaryIdType + '\'' +
                ", secondaryIdNumber='" + secondaryIdNumber + '\'' +
                ", kinFirstName='" + kinFirstName + '\'' +
                ", kinLastName='" + kinLastName + '\'' +
                ", kinMsisdn='" + kinMsisdn + '\'' +
                '}';
    }
}
