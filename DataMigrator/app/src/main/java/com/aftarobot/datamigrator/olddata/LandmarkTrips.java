package com.aftarobot.datamigrator.olddata;


import java.util.HashMap;
import java.util.List;

/**
 * Created by aubreymalabie on 6/5/16.
 */
public class LandmarkTrips {

    String landmarkName;
    String cityName;
    HashMap<String, TripDTO> trips;
    List<TripDTO> tripList;

    public String getLandmarkName() {
        return landmarkName;
    }

    public void setLandmarkName(String landmarkName) {
        this.landmarkName = landmarkName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

//    public HashMap<String, TripDTO> getTrips() {
//        return trips;
//    }
//
//    public void setTrips(HashMap<String, TripDTO> trips) {
//        this.trips = trips;
//    }

    public List<TripDTO> getTripList() {
        return tripList;
    }

    public void setTripList(List<TripDTO> tripList) {
        this.tripList = tripList;
    }
}
