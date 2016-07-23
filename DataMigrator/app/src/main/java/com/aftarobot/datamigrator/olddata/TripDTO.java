/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.datamigrator.olddata;

import java.io.Serializable;

/**
 *
 * @author Aubrey Malabie
 */
public class TripDTO implements Serializable{

    private int tripID, marshalID, landmarkID, vehicleID, numberOfPassengers;
    private long dateDipatched, dateArrived;
    private String vehicleReg, landmarkName, marshalName, status,associatioName;

    public TripDTO() {

    }

    public long getDateDipatched() {
        return dateDipatched;
    }

    public String getAssociatioName() {
        return associatioName;
    }

    public void setAssociatioName(String associatioName) {
        this.associatioName = associatioName;
    }

    public void setDateDipatched(long dateDipatched) {
        this.dateDipatched = dateDipatched;
    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public int getMarshalID() {
        return marshalID;
    }

    public void setMarshalID(int marshalID) {
        this.marshalID = marshalID;
    }

    public int getLandmarkID() {
        return landmarkID;
    }

    public void setLandmarkID(int landmarkID) {
        this.landmarkID = landmarkID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public long getDate() {
        return dateDipatched;
    }

    public void setDate(long date) {
        this.dateDipatched = date;
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
}
