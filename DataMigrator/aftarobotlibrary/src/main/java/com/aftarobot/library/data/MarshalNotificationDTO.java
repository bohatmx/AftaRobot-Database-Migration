/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.library.data;

import java.io.Serializable;

/**
 *
 * @author Aubrey Malabie
 */
public class MarshalNotificationDTO implements Serializable{

    private int marshalNotificationID, marshalID, associationID;
    private String message, status;
    private long date;

    public MarshalNotificationDTO() {

    }

    public int getMarshalNotificationID() {
        return marshalNotificationID;
    }

    public void setMarshalNotificationID(int marshalNotificationID) {
        this.marshalNotificationID = marshalNotificationID;
    }

    public int getMarshalID() {
        return marshalID;
    }

    public void setMarshalID(int marshalID) {
        this.marshalID = marshalID;
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
