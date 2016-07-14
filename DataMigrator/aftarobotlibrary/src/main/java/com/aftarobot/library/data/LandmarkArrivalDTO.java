package com.aftarobot.library.data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by aubreymalabie on 6/6/16.
 */
public class LandmarkArrivalDTO implements Serializable, Comparable<LandmarkArrivalDTO>{

    private String arrivalID, landmarkID, landmarkName,
        driverID, driverName,
        vehicleID, associationID, associationName, countryID;
    private long dateArrived;

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getArrivalID() {
        return arrivalID;
    }

    public void setArrivalID(String arrivalID) {
        this.arrivalID = arrivalID;
    }

    public String getLandmarkID() {
        return landmarkID;
    }

    public void setLandmarkID(String landmarkID) {
        this.landmarkID = landmarkID;
    }

    public String getLandmarkName() {
        return landmarkName;
    }

    public void setLandmarkName(String landmarkName) {
        this.landmarkName = landmarkName;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getAssociationID() {
        return associationID;
    }

    public void setAssociationID(String associationID) {
        this.associationID = associationID;
    }

    public String getAssociationName() {
        return associationName;
    }

    public void setAssociationName(String associationName) {
        this.associationName = associationName;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public long getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(long dateArrived) {
        this.dateArrived = dateArrived;
    }

    @Override
    public int compareTo(LandmarkArrivalDTO another) {
        return new Date(dateArrived).compareTo(new Date(another.dateArrived));
    }
}
