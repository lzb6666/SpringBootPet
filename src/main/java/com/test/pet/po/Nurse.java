package com.test.pet.po;

import java.util.UUID;

/**
 * Created by zhong on 2018/11/26 18:11
 */
public class Nurse {
    private String nurseID;
    private String announcer;
    private String recipient;
    private String recTime;


    private String imgURL;
    private String variety;
    private String sex;
    private String age;
    private String health;
    private String note;

    private String other;

    private String status;

    private String name;

    public Nurse(String nurseID, String announcer, String recipient, String recTime, String imgURL, String variety, String sex, String age, String health, String note, String other, String status, String name) {
        this.nurseID = nurseID;
        this.announcer = announcer;
        this.recipient = recipient;
        this.recTime = recTime;
        this.imgURL = imgURL;
        this.variety = variety;
        this.sex = sex;
        this.age = age;
        this.health = health;
        this.note = note;
        this.other = other;
        this.status = status;
        this.name = name;
    }

    public Nurse() {
        this.nurseID=UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNurseID() {
        return nurseID;
    }

    public void setNurseID(String nurseID) {
        this.nurseID = nurseID;
    }

    public String getAnnouncer() {
        return announcer;
    }

    public void setAnnouncer(String announcer) {
        this.announcer = announcer;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecTime() {
        return recTime;
    }

    public void setRecTime(String recTime) {
        this.recTime = recTime;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
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

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
