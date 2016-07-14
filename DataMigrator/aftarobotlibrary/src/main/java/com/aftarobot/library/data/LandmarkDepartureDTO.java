package com.aftarobot.library.data;

/**
 * Created by aubreymalabie on 6/6/16.
 */
public class LandmarkDepartureDTO {
    private String departureID, landmarkID, landmarkName,
            driverID, driverName,
            vehicleID, associationID, associationName, countryID;
    private long dateDeparted;

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

    public String getDepartureID() {
        return departureID;
    }

    public void setDepartureID(String departureID) {
        this.departureID = departureID;
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

    public long getDateDeparted() {
        return dateDeparted;
    }

    public void setDateDeparted(long dateDeparted) {
        this.dateDeparted = dateDeparted;
    }
}
