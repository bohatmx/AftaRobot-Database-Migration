/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.library.data;

/**
 *
 * @author SiphoKobue
 */
public class VehicleInfoDTO {

    private int vehicleProfileID;
    private String type;
    private String year;
    private String make;
    private int capacity;
    private String operatingLicence;
    private long operatingLicenceExpDate;
    private long date;
    private String status;
    private int vehicleID;

    public VehicleInfoDTO() {

    }

    public int getVehicleProfileID() {
        return vehicleProfileID;
    }

    public void setVehicleProfileID(int vehicleProfileID) {
        this.vehicleProfileID = vehicleProfileID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getOperatingLicence() {
        return operatingLicence;
    }

    public void setOperatingLicence(String operatingLicence) {
        this.operatingLicence = operatingLicence;
    }

    public long getOperatingLicenceExpDate() {
        return operatingLicenceExpDate;
    }

    public void setOperatingLicenceExpDate(long operatingLicenceExpDate) {
        this.operatingLicenceExpDate = operatingLicenceExpDate;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

}
