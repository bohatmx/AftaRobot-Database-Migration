/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.library.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Aubrey Malabie
 */
public class LandmarkDTO implements Serializable, Comparable<LandmarkDTO> {

    private String landmarkID, routeCityID, cityID, routeID, countryID, provinceID,routeName, routeCityName;
    private int rankSequenceNumber;
    private double latitude, longitude;
    private String landmarkName, distanceInbound, distanceOutbound, estimatedTimeInbound, estimatedTimeOutbound, status, cityName;
    private long date, numberOfPendingRequests, numberOfWaitingCommuters;
    private List<TripDTO> tripList = new ArrayList<>();

    private HashMap<String, TripDTO> trips;
    @JsonIgnore
    private boolean sortByRankSequence;

    public boolean isSortByRankSequence() {
        return sortByRankSequence;
    }

    public void setSortByRankSequence(boolean sortByRankSequence) {
        this.sortByRankSequence = sortByRankSequence;
    }

    public LandmarkDTO() {

    }

    public String getRouteCityName() {
        return routeCityName;
    }

    public void setRouteCityName(String routeCityName) {
        this.routeCityName = routeCityName;
    }

    public HashMap<String, TripDTO> getTrips() {
        return trips;
    }

    public void setTrips(HashMap<String, TripDTO> trips) {
        this.trips = trips;
    }

    public String getRouteName() {
        return routeName;
    }

    public List<TripDTO> getTripList() {
        return tripList;
    }

    public void setTripList(List<TripDTO> tripList) {
        this.tripList = tripList;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
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

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public long getNumberOfPendingRequests() {
        return numberOfPendingRequests;
    }

    public void setNumberOfPendingRequests(long numberOfPendingRequests) {
        this.numberOfPendingRequests = numberOfPendingRequests;
    }

    public long getNumberOfWaitingCommuters() {
        return numberOfWaitingCommuters;
    }

    public void setNumberOfWaitingCommuters(long numberOfWaitingCommuters) {
        this.numberOfWaitingCommuters = numberOfWaitingCommuters;
    }

    public String getLandmarkID() {
        return landmarkID;
    }

    public void setLandmarkID(String landmarkID) {
        this.landmarkID = landmarkID;
    }

    public String getRouteCityID() {
        return routeCityID;
    }

    public void setRouteCityID(String routeCityID) {
        this.routeCityID = routeCityID;
    }

    public int getRankSequenceNumber() {
        return rankSequenceNumber;
    }

    public void setRankSequenceNumber(int rankSequenceNumber) {
        this.rankSequenceNumber = rankSequenceNumber;
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

    public String getLandmarkName() {
        return landmarkName;
    }

    public void setLandmarkName(String landmarkName) {
        this.landmarkName = landmarkName;
    }

    public String getDistanceInbound() {
        return distanceInbound;
    }

    public void setDistanceInbound(String distanceInbound) {
        this.distanceInbound = distanceInbound;
    }

    public String getDistanceOutbound() {
        return distanceOutbound;
    }

    public void setDistanceOutbound(String distanceOutbound) {
        this.distanceOutbound = distanceOutbound;
    }

    public String getEstimatedTimeInbound() {
        return estimatedTimeInbound;
    }

    public void setEstimatedTimeInbound(String estimatedTimeInbound) {
        this.estimatedTimeInbound = estimatedTimeInbound;
    }

    public String getEstimatedTimeOutbound() {
        return estimatedTimeOutbound;
    }

    public void setEstimatedTimeOutbound(String estimatedTimeOutbound) {
        this.estimatedTimeOutbound = estimatedTimeOutbound;
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

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public int compareTo(LandmarkDTO another) {
        if (isSortByRankSequence()) {
            if (this.rankSequenceNumber < another.rankSequenceNumber) {
                return -1;
            }
            if (this.rankSequenceNumber > another.rankSequenceNumber) {
                return 1;
            }
        } else {
            return this.landmarkName.compareTo(another.landmarkName);
        }

        return 0;
    }
}
