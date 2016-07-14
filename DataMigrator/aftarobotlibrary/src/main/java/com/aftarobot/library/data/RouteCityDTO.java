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
 * @author Sipho
 */
public class RouteCityDTO implements Serializable, Comparable<RouteCityDTO> {

    private String routeCityID, routeID, cityID, provinceID, countryID;
    private long date;
    private String status, routeName, cityName;
    private List<LandmarkDTO> landmarkList = new ArrayList<>();
    private HashMap<String,LandmarkDTO> landmarks;

    public RouteCityDTO() {

    }

    public HashMap<String, LandmarkDTO> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(HashMap<String, LandmarkDTO> landmarks) {
        this.landmarks = landmarks;
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

    public String getRouteCityID() {
        return routeCityID;
    }

    public void setRouteCityID(String routeCityID) {
        this.routeCityID = routeCityID;
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
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

    @Override
    public int compareTo(RouteCityDTO another) {
        return this.cityName.compareTo(another.cityName);
    }
}
