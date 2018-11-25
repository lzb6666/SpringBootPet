package com.test.pet.po;

import java.util.UUID;

public class Pet {
    private String petID;
    private String name;
    private String detail;
    private String imgURL;
    private String owner;
    private String variety;
    private String sex;
    private String age;
    private String healthStatus;
    private String other;
    private String phoneNum;

    public Pet(String petID, String name, String detail, String imgURL, String owner, String variety, String sex, String age, String healthStatus, String other, String phoneNum) {
        this.petID = petID;
        this.name = name;
        this.detail = detail;
        this.imgURL = imgURL;
        this.owner = owner;
        this.variety = variety;
        this.sex = sex;
        this.age = age;
        this.healthStatus = healthStatus;
        this.other = other;
        this.phoneNum = phoneNum;
    }

    public Pet(String name, String detail, String imgURL, String owner, String variety, String sex, String age, String healthStatus, String other) {
        this.petID= UUID.randomUUID().toString();
        this.name = name;
        this.detail = detail;
        this.imgURL = imgURL;
        this.owner = owner;
        this.variety = variety;
        this.sex = sex;
        this.age = age;
        this.healthStatus = healthStatus;
        this.other = other;
    }

    public Pet(){
        this.petID= UUID.randomUUID().toString();
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Pet(String name, String detail, String imgURL) {
        this.petID= UUID.randomUUID().toString();
        this.name = name;
        this.detail = detail;
        this.imgURL = imgURL;
    }

    public Pet(String petID, String name, String detail, String imgURL, String owner) {
        this.petID = petID;
        this.name = name;
        this.detail = detail;
        this.imgURL = imgURL;
        this.owner = owner;
    }

    public String getPetID() {
        return petID;
    }

    public void setPetID(String petID) {
        this.petID = petID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
