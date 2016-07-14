/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.library.data;

import java.io.Serializable;

/**
 *
 * @author Sipho
 */
public class MarshalLogDTO implements Serializable{

    private int marshalLogID, marshalID, landmarkID;
    private long loginDate, logoutDate;
    private String status;
    private double latitude, longitude;

    public MarshalLogDTO() {

    }

    public int getMarshalLogID() {
        return marshalLogID;
    }

    public void setMarshalLogID(int marshalLogID) {
        this.marshalLogID = marshalLogID;
    }

    public int getMarshalID() {
        return marshalID;
    }

    public void setMarshalID(int marshalID) {
        this.marshalID = marshalID;
    }

    public int getLandmarkID() {
        return landmarkID;
    }

    public void setLandmarkID(int landmarkID) {
        this.landmarkID = landmarkID;
    }

    public long getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(long loginDate) {
        this.loginDate = loginDate;
    }

    public long getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(long logoutDate) {
        this.logoutDate = logoutDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
