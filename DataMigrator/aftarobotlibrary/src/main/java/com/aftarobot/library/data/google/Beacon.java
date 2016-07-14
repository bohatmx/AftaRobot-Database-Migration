package com.aftarobot.library.data.google;

import java.io.Serializable;

/**
 * Created by aubreymalabie on 6/11/16.
 */
public class Beacon implements Serializable {
    private String beaconName;
    private AdvertisedId advertisedId;
    private String status;
    private String placeId;
    private LatLng latLng;
    private IndoorLevel indoorLevel;
    private String expectedStability;
    private String description;

    public String getBeaconName() {
        return this.beaconName;
    }

    public void setBeaconName(String beaconName) {
        this.beaconName = beaconName;
    }


    public AdvertisedId getAdvertisedId() {
        return this.advertisedId;
    }

    public void setAdvertisedId(AdvertisedId advertisedId) {
        this.advertisedId = advertisedId;
    }


    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getPlaceId() {
        return this.placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }


    public LatLng getLatLng() {
        return this.latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }


    public IndoorLevel getIndoorLevel() {
        return this.indoorLevel;
    }

    public void setIndoorLevel(IndoorLevel indoorLevel) {
        this.indoorLevel = indoorLevel;
    }


    public String getExpectedStability() {
        return this.expectedStability;
    }

    public void setExpectedStability(String expectedStability) {
        this.expectedStability = expectedStability;
    }


    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
