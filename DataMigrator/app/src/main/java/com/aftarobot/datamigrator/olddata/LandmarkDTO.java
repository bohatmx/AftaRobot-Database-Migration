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
public class LandmarkDTO implements Serializable {

    private int landmarkID, routeCityID, rankSequenceNumber, cityID, routeID;
    private double latitude, longitude;
    private String landmarkName, distanceInbound, distanceOutbound, estimatedTimeInbound, estimatedTimeOutbound, status, cityName;
    private long date, numberOfPendingRequests, numberOfWaitingCommuters;
    private List<TripDTO> tripList = new ArrayList<>();


    public LandmarkDTO() {

    }

    public List<TripDTO> getTripList() {
        return tripList;
    }

    public void setTripList(List<TripDTO> tripList) {
        this.tripList = tripList;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
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

    public int getLandmarkID() {
        return landmarkID;
    }

    public void setLandmarkID(int landmarkID) {
        this.landmarkID = landmarkID;
    }

    public int getRouteCityID() {
        return routeCityID;
    }

    public void setRouteCityID(int routeCityID) {
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

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
