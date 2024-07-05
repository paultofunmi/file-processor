package com.example.fileprocessor.dto;

public class TransactionDetailsDto {

    private Boolean st;

    private String msgid;

    private String msg;

    private TransactionDetailsDataDto data;


    public TransactionDetailsDto() {
    }

    public TransactionDetailsDto(Boolean st, String msgid, String msg, TransactionDetailsDataDto data) {
        this.st = st;
        this.msgid = msgid;
        this.msg = msg;
        this.data = data;
    }

    public Boolean getSt() {
        return st;
    }

    public void setSt(Boolean st) {
        this.st = st;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public TransactionDetailsDataDto getData() {
        return data;
    }

    public void setData(TransactionDetailsDataDto data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TransactionDetailsDto{" +
                "st=" + st +
                ", msgid='" + msgid + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
