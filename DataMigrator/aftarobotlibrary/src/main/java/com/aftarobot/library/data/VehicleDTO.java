/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.library.data;

import java.io.Serializable;

/**
 * @author Aubrey Malabie
 */
public class VehicleDTO implements Serializable {

    private String vehicleID, ownerID, associationID, countryID;
    private int capacity;
    private long date, licenceExpiryDate, policyIssueDate, policyExpiryDate;
    private OwnerDTO owner;
    private String driverName, driverPhone, year, make, operatingLicence,
            vehicleReg, status, model, type, policyNumber;

    public VehicleDTO() {

    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public long getLicenceExpiryDate() {
        return licenceExpiryDate;
    }

    public void setLicenceExpiryDate(long licenceExpiryDate) {
        this.licenceExpiryDate = licenceExpiryDate;
    }

    public long getPolicyIssueDate() {
        return policyIssueDate;
    }

    public void setPolicyIssueDate(long policyIssueDate) {
        this.policyIssueDate = policyIssueDate;
    }

    public long getPolicyExpiryDate() {
        return policyExpiryDate;
    }

    public void setPolicyExpiryDate(long policyExpiryDate) {
        this.policyExpiryDate = policyExpiryDate;
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

    public String getOperatingLicence() {
        return operatingLicence;
    }

    public void setOperatingLicence(String operatingLicence) {
        this.operatingLicence = operatingLicence;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getAssociationID() {
        return associationID;
    }

    public void setAssociationID(String associationID) {
        this.associationID = associationID;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getVehicleReg() {
        return vehicleReg;
    }

    public void setVehicleReg(String vehicleReg) {
        this.vehicleReg = vehicleReg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }
}
