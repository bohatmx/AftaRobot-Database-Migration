/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.datamigrator.olddata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sipho
 */
public class AssociationDTO implements Serializable{

    private int associationID, cityID;
    private String description, phone, status, cityName;
    private long date;
    List<VehicleDTO> vehicleList = new ArrayList<>();
    List<AdminDTO> adminList = new ArrayList<>();
    List<DriverDTO> driverList = new ArrayList<>();
    List<MarshalDTO> marshalList = new ArrayList<>();
    List<RouteDTO> routeList = new ArrayList<>();

    public AssociationDTO() {

    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<VehicleDTO> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<VehicleDTO> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<AdminDTO> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<AdminDTO> adminList) {
        this.adminList = adminList;
    }

    public List<DriverDTO> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<DriverDTO> driverList) {
        this.driverList = driverList;
    }

    public List<MarshalDTO> getMarshalList() {
        return marshalList;
    }

    public void setMarshalList(List<MarshalDTO> marshalList) {
        this.marshalList = marshalList;
    }

    public List<RouteDTO> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<RouteDTO> routeList) {
        this.routeList = routeList;
    }

    public int getAssociationID() {
        return associationID;
    }

    public void setAssociationID(int associationID) {
        this.associationID = associationID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
