/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.library.data;

/**
 *
 * @author Aubrey MalabieKobue
 */
public class DriverProfileDTO {

    private int driverProfileID;
    private String idNo;
    private String licenceNo;
    private long issueDate;
    private long expiryDate;
    private int licenceRestrictions;
    private String code, address;
    private long date;
    private String status;
    private int driverID;

    public DriverProfileDTO() {

    }

    public int getDriverProfileID() {
        return driverProfileID;
    }

    public void setDriverProfileID(int driverProfileID) {
        this.driverProfileID = driverProfileID;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public long getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(long issueDate) {
        this.issueDate = issueDate;
    }

    public long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(long expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getLicenceRestrictions() {
        return licenceRestrictions;
    }

    public void setLicenceRestrictions(int licenceRestrictions) {
        this.licenceRestrictions = licenceRestrictions;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
