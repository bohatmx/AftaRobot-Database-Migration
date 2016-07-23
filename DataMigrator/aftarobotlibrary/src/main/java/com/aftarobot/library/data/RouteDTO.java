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
 * @author Aubrey Malabie
 */
public class RouteDTO implements Serializable, Comparable<RouteDTO> {

    private String routeID, associationID, countryID, provinceID, cityID;
    private String name, status, associationName;
    private long date;
    private List<RoutePointsDTO> routePointList = new ArrayList<>();
    private List<LandmarkDTO> landmarkList = new ArrayList<>();

    HashMap<String,RoutePointsDTO> routePoints;
    HashMap<String,LandmarkDTO> landmarks;

    public RouteDTO() {

    }

    public List<LandmarkDTO> getLandmarkList() {
        return landmarkList;
    }

    public void setLandmarkList(List<LandmarkDTO> landmarkList) {
        this.landmarkList = landmarkList;
    }

    public HashMap<String, LandmarkDTO> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(HashMap<String, LandmarkDTO> landmarks) {
        this.landmarks = landmarks;
    }

    public List<RoutePointsDTO> getRoutePointList() {
        return routePointList;
    }

    public void setRoutePointList(List<RoutePointsDTO> routePointList) {
        this.routePointList = routePointList;
    }


    public HashMap<String, RoutePointsDTO> getRoutePoints() {
        return routePoints;
    }

    public void setRoutePoints(HashMap<String, RoutePointsDTO> routePoints) {
        this.routePoints = routePoints;
    }


    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getAssociationID() {
        return associationID;
    }

    public String getAssociationName() {
        return associationName;
    }

    public void setAssociationName(String associationName) {
        this.associationName = associationName;
    }

    public void setAssociationID(String associationID) {
        this.associationID = associationID;
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public int compareTo(RouteDTO another) {
        return this.name.compareTo(another.name);
    }
}
