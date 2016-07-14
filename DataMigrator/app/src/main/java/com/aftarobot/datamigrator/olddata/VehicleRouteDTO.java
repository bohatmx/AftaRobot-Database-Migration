/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.datamigrator.olddata;

import java.io.Serializable;

/**
 *
 * @author Sipho
 */
public class VehicleRouteDTO implements Serializable{

    private int vehicleRouteID, vehicleID, routeID;
    private String status;
    private long date;

    public VehicleRouteDTO() {

    }

    public int getVehicleRouteID() {
        return vehicleRouteID;
    }

    public void setVehicleRouteID(int vehicleRouteID) {
        this.vehicleRouteID = vehicleRouteID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
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
