package com.test.pet.po;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Adopt {
    private String recordID;
    private String userID;
    private String petID;
    private String adoptTime;
    private String status;

    public Adopt(String userID, String petID,String status) {
        this.recordID= UUID.randomUUID().toString();
        this.userID = userID;
        this.petID = petID;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.adoptTime=df.format(new Date());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPetID() {
        return petID;
    }

    public void setPetID(String petID) {
        this.petID = petID;
    }

    public String getAdoptTime() {
        return adoptTime;
    }

    public void setAdoptTime(String adoptTime) {
        this.adoptTime = adoptTime;
    }
}
