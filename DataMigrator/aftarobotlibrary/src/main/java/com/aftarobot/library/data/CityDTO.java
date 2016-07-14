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
public class CityDTO implements Serializable, Comparable<CityDTO>{

    private String cityID, provinceID, countryID;
    private String name, status, provinceName;
    private double latitude, longitude;
    private String countryName;
    private long date;

    private HashMap<String, RouteDTO> routes;
    private List<RouteCityDTO> routeCityList = new ArrayList<>();
    private  List<AssociationDTO> associationList = new ArrayList<>();
    private HashMap<String, AssociationDTO> associations;
    private HashMap<String, RouteCityDTO> routeCities;

    public CityDTO() {

    }

    public HashMap<String, RouteDTO> getRoutes() {
        return routes;
    }

    public void setRoutes(HashMap<String, RouteDTO> routes) {
        this.routes = routes;
    }

    public List<AssociationDTO> getAssociationList() {
        return associationList;
    }

    public void setAssociationList(List<AssociationDTO> associationList) {
        this.associationList = associationList;
    }

    public HashMap<String, AssociationDTO> getAssociations() {
        return associations;
    }

    public void setAssociations(HashMap<String, AssociationDTO> associations) {
        this.associations = associations;
    }

    public HashMap<String, RouteCityDTO> getRouteCities() {
        return routeCities;
    }

    public void setRouteCities(HashMap<String, RouteCityDTO> routeCities) {
        if (routeCities != null) {
            routeCityList.addAll(routeCities.values());
        }
        this.routeCities = routeCities;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
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

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public int compareTo(CityDTO another) {
        if (this.name == null || another.name == null) {
            return 0;
        }
        return this.name.compareTo(another.name);
    }
}
