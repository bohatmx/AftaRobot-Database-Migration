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
 * @author Aubrey Malabie
 */
public class RouteDTO implements Serializable {

    private String routeID, associationID;
    private String name, status;
    private long date;
    private List<RoutePointsDTO> routePoints = new ArrayList<>();
    private List<RouteCityDTO> routeCityList = new ArrayList<>();

    public RouteDTO() {

    }

    public List<RouteCityDTO> getRouteCityList() {
        return routeCityList;
    }

    public void setRouteCityList(List<RouteCityDTO> routeCityList) {
        this.routeCityList = routeCityList;
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

    public List<RoutePointsDTO> getRoutePoints() {
        return routePoints;
    }

    public void setRoutePoints(List<RoutePointsDTO> routePoints) {
        this.routePoints = routePoints;
    }
}
