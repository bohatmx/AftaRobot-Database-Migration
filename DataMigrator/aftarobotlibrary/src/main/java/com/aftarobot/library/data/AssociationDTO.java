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
public class AssociationDTO implements Serializable{

    private String associationID, cityID, countryID, provinceID;
    private String description, phone, status, countryName;
    private long date;
    List<VehicleDTO> vehicleList = new ArrayList<>();
    List<AdminDTO> adminList = new ArrayList<>();
    List<DriverDTO> driverList = new ArrayList<>();
    List<MarshalDTO> marshalList = new ArrayList<>();
    List<RouteDTO> routeList = new ArrayList<>();
    HashMap<String, VehicleDTO> vehicles;
    HashMap<String, AdminDTO> admins;
    HashMap<String,DriverDTO> drivers;
    HashMap<String,MarshalDTO> marshals;
    HashMap<String, RouteDTO> routes;

    public AssociationDTO() {

    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public HashMap<String, VehicleDTO> getVehicles() {
        return vehicles;
    }

    public void setVehicles(HashMap<String, VehicleDTO> vehicles) {
        this.vehicles = vehicles;
    }

    public HashMap<String, AdminDTO> getAdmins() {
        return admins;
    }

    public void setAdmins(HashMap<String, AdminDTO> admins) {
        this.admins = admins;
    }

    public HashMap<String, DriverDTO> getDrivers() {
        return drivers;
    }

    public void setDrivers(HashMap<String, DriverDTO> drivers) {
        this.drivers = drivers;
    }

    public HashMap<String, MarshalDTO> getMarshals() {
        return marshals;
    }

    public void setMarshals(HashMap<String, MarshalDTO> marshals) {
        this.marshals = marshals;
    }

    public HashMap<String, RouteDTO> getRoutes() {
        return routes;
    }

    public void setRoutes(HashMap<String, RouteDTO> routes) {
        this.routes = routes;
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

    public String getAssociationID() {
        return associationID;
    }

    public void setAssociationID(String associationID) {
        this.associationID = associationID;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
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
