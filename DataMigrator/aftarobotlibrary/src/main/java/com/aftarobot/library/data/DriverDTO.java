/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.library.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Sipho
 */
public class DriverDTO implements Serializable{

    private String driverID, associationID, vehicleID, countryID;
    private String gcmID, name, surname, email, phone, password, status;
    private long date;

    private List<DriverProfileDTO> driverProfileList = new ArrayList<>();
    private HashMap<String, DriverProfileDTO> driverProfiles;

    public DriverDTO() {

    }

    public HashMap<String, DriverProfileDTO> getDriverProfiles() {
        return driverProfiles;
    }

    public void setDriverProfiles(HashMap<String, DriverProfileDTO> driverProfiles) {
        this.driverProfiles = driverProfiles;
    }

    public List<DriverProfileDTO> getDriverProfileList() {
        return driverProfileList;
    }

    public void setDriverProfileList(List<DriverProfileDTO> driverProfileList) {
        this.driverProfileList = driverProfileList;
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

    public String getDriverID() {
        return driverID;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getGcmID() {
        return gcmID;
    }

    public void setGcmID(String gcmID) {
        this.gcmID = gcmID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
