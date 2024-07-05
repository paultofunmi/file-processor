package com.example.fileprocessor.reader.ceva.out;

public class TransactionInfo {

    private String externalId;
    private String txnType;

    private String note;

    private String countryCode;

    private String td;

    private String ts;

    public TransactionInfo(String externalId, String txnType, String note, String countryCode, String td, String ts) {
        this.externalId = externalId;
        this.txnType = txnType;
        this.note = note;
        this.countryCode = countryCode;
        this.td = td;
        this.ts = ts;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTd() {
        return td;
    }

    public void setTd(String td) {
        this.td = td;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
}