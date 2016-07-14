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
public class VehiclePolicyDTO {

    private int vehiclePolicyID;
    private String policyNo;
    private long issueDate;
    private long expiryDate;
    private long date;
    private String status;
    private int vehicleID;

    public VehiclePolicyDTO() {

    }

    public int getVehiclePolicyID() {
        return vehiclePolicyID;
    }

    public void setVehiclePolicyID(int vehiclePolicyID) {
        this.vehiclePolicyID = vehiclePolicyID;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
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
