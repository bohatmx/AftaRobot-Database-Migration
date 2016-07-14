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
public class CityDTO implements Serializable{

    private int cityID, provinceID;
    private String name, status;
    private double latitude, longitude;
    private int routeID;
    private long date;
    private List<RouteCityDTO> routeCityList = new ArrayList<>();
    private  List<AssociationDTO> associationList = new ArrayList<>();

    public CityDTO() {

    }

    public List<AssociationDTO> getAssociationList() {
        return associationList;
    }

    public void setAssociationList(List<AssociationDTO> associationList) {
        this.associationList = associationList;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public List<RouteCityDTO> getRouteCityList() {
        return routeCityList;
    }

    public void setRouteCityList(List<RouteCityDTO> routeCityList) {
        this.routeCityList = routeCityList;
    }

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }
}
