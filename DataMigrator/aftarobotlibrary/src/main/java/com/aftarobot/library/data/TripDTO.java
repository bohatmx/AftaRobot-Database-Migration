/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.library.data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Sipho
 */
public class TripDTO implements Serializable, Comparable<TripDTO> {

    private String tripID, marshalID, landmarkID, vehicleID, cityID, routeID, routeCityID, associationID;
    private int numberOfPassengers;
    private long dateDispatched, dateArrived;
    private String vehicleReg, landmarkName, marshalName, status, cityName, routeName, routeCityName, associatioName;

    public TripDTO() {

    }

    public String getAssociationID() {
        return associationID;
    }

    public void setAssociationID(String associationID) {
        this.associationID = associationID;
    }

    public String getAssociatioName() {
        return associatioName;
    }

    public void setAssociatioName(String associatioName) {
        this.associatioName = associatioName;
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

    public String getRouteCityID() {
        return routeCityID;
    }

    public void setRouteCityID(String routeCityID) {
        this.routeCityID = routeCityID;
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

    public String getRouteCityName() {
        return routeCityName;
    }

    public void setRouteCityName(String routeCityName) {
        this.routeCityName = routeCityName;
    }

    public long getDateDispatched() {
        return dateDispatched;
    }

    public void setDateDispatched(long dateDispatched) {
        this.dateDispatched = dateDispatched;
    }

    public String getTripID() {
        return tripID;
    }

    public void setTripID(String tripID) {
        this.tripID = tripID;
    }

    public String getMarshalID() {
        return marshalID;
    }

    public void setMarshalID(String marshalID) {
        this.marshalID = marshalID;
    }

    public String getLandmarkID() {
        return landmarkID;
    }

    public void setLandmarkID(String landmarkID) {
        this.landmarkID = landmarkID;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public long getDate() {
        return dateDispatched;
    }

    public void setDate(long date) {
        this.dateDispatched = date;
    }

    public String getVehicleReg() {
        return vehicleReg;
    }

    public void setVehicleReg(String vehicleReg) {
        this.vehicleReg = vehicleReg;
    }

    public String getLandmarkName() {
        return landmarkName;
    }

    public void setLandmarkName(String landmarkName) {
        this.landmarkName = landmarkName;
    }

    public String getMarshalName() {
        return marshalName;
    }

    public void setMarshalName(String marshalName) {
        this.marshalName = marshalName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(long dateArrived) {
        this.dateArrived = dateArrived;
    }

    @Override
    public int compareTo(TripDTO another) {
        return new Date(this.dateDispatched).compareTo(new Date(another.dateDispatched)) * -1;
    }
}
