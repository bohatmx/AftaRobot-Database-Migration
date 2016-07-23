/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.library.data;

import java.io.Serializable;

/**
 * @author Aubrey Malabie
 */
public class CommuterRequestDTO implements Serializable {

    private int commuterRequestID, originLandmarkID, destinationLandmarkID,
            deviceType, rankLandmarkID, commuterID, marshalID, estimatedTimeOfArrival;
    private long date, requestStartTime, requestEndTime, dateUpdated;
    private double distanceFromRank, latitude, longitude;
    private String requestStatus, origin, destination;

    public CommuterRequestDTO() {

    }

    public int getCommuterRequestID() {
        return commuterRequestID;
    }

    public void setCommuterRequestID(int commuterRequestID) {
        this.commuterRequestID = commuterRequestID;
    }

    public int getOriginLandmarkID() {
        return originLandmarkID;
    }

    public void setOriginLandmarkID(int originLandmarkID) {
        this.originLandmarkID = originLandmarkID;
    }

    public int getDestinationLandmarkID() {
        return destinationLandmarkID;
    }

    public void setDestinationLandmarkID(int destinationLandmarkID) {
        this.destinationLandmarkID = destinationLandmarkID;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public int getRankLandmarkID() {
        return rankLandmarkID;
    }

    public void setRankLandmarkID(int rankLandmarkID) {
        this.rankLandmarkID = rankLandmarkID;
    }

    public int getCommuterID() {
        return commuterID;
    }

    public void setCommuterID(int commuterID) {
        this.commuterID = commuterID;
    }

    public int getMarshalID() {
        return marshalID;
    }

    public void setMarshalID(int marshalID) {
        this.marshalID = marshalID;
    }

    public int getEstimatedTimeOfArrival() {
        return estimatedTimeOfArrival;
    }

    public void setEstimatedTimeOfArrival(int estimatedTimeOfArrival) {
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getRequestStartTime() {
        return requestStartTime;
    }

    public void setRequestStartTime(long requestStartTime) {
        this.requestStartTime = requestStartTime;
    }

    public long getRequestEndTime() {
        return requestEndTime;
    }

    public void setRequestEndTime(long requestEndTime) {
        this.requestEndTime = requestEndTime;
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public double getDistanceFromRank() {
        return distanceFromRank;
    }

    public void setDistanceFromRank(double distanceFromRank) {
        this.distanceFromRank = distanceFromRank;
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

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
