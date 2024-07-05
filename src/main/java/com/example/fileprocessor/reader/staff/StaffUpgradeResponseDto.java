package com.example.fileprocessor.reader.staff;

public class StaffUpgradeResponseDto {

    private Boolean st;

    private String msgid;

    private String msg;

    private StaffUpgradeProcessResponseDto processResponse;

    public StaffUpgradeResponseDto() {
    }

    public StaffUpgradeResponseDto(Boolean st, String msgid, String msg, StaffUpgradeProcessResponseDto processResponse) {
        this.st = st;
        this.msgid = msgid;
        this.msg = msg;
        this.processResponse = processResponse;
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

    public StaffUpgradeProcessResponseDto getProcessResponse() {
        return processResponse;
    }

    public void setProcessResponse(StaffUpgradeProcessResponseDto processResponse) {
        this.processResponse = processResponse;
    }
}
