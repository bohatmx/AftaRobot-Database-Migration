/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.datamigrator.olddata;

import java.io.Serializable;

/**
 *
 * @author Aubrey Malabie
 */
public class ChairpersonNotificationDTO implements Serializable{

    private int chairpersonNotificationID, chairpersonID, associationID;
    private String message, status;
    private long date;

    public ChairpersonNotificationDTO() {

    }

    public int getChairpersonNotificationID() {
        return chairpersonNotificationID;
    }

    public void setChairpersonNotificationID(int chairpersonNotificationID) {
        this.chairpersonNotificationID = chairpersonNotificationID;
    }

    public int getChairpersonID() {
        return chairpersonID;
    }

    public void setChairpersonID(int chairpersonID) {
        this.chairpersonID = chairpersonID;
    }

    public int getAssociationID() {
        return associationID;
    }

    public void setAssociationID(int associationID) {
        this.associationID = associationID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
