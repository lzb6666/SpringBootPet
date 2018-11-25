package com.test.pet.po;

public class VCode {
    private String phoneNum;
    private String code;
    private String type;

    public VCode(String phoneNum, String vcode, String type) {
        this.phoneNum = phoneNum;
        this.code = vcode;
        this.type = type;
    }

    public VCode() {
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
