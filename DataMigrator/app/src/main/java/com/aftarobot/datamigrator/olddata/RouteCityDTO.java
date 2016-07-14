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
 * @author Sipho
 */
public class RouteCityDTO implements Serializable {

    private int routeCityID, routeID, cityID;
    private long date;
    private String status, routeName, cityName;
    private List<LandmarkDTO> landmarkList = new ArrayList<>();

    public RouteCityDTO() {

    }

    public int getRouteCityID() {
        return routeCityID;
    }

    public void setRouteCityID(int routeCityID) {
        this.routeCityID = routeCityID;
    }

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
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

    public List<LandmarkDTO> getLandmarkList() {
        return landmarkList;
    }

    public void setLandmarkList(List<LandmarkDTO> landmarkList) {
        this.landmarkList = landmarkList;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
}
