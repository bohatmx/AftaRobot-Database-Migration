package com.aftarobot.library.data;

/**
 * Created by aubreymalabie on 6/6/16.
 */
public class OnTripRecordDTO {

    private String tripRecordID, landmarkID, landmarkName,
            vehicleID, associationID, associationName, countryID;
    private long dateARecorded, numberOfPassengers;
    private double latitude, longitude;

    public String getTripRecordID() {
        return tripRecordID;
    }

    public void setTripRecordID(String tripRecordID) {
        this.tripRecordID = tripRecordID;
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

    public long getDateARecorded() {
        return dateARecorded;
    }

    public void setDateARecorded(long dateARecorded) {
        this.dateARecorded = dateARecorded;
    }

    public long getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(long numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
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
}
