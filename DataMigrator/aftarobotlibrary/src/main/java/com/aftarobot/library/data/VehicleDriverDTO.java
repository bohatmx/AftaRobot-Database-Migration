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
public class VehicleDriverDTO implements Serializable{

    private int vehicleDriverID, vehicleID, driverID;
    private String status;
    private long date;

    public VehicleDriverDTO() {

    }

    public int getVehicleDriverID() {
        return vehicleDriverID;
    }

    public void setVehicleDriverID(int vehicleDriverID) {
        this.vehicleDriverID = vehicleDriverID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
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
