/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.datamigrator.olddata;

import java.io.Serializable;

/**
 *
 * @author Sipho
 */
public class FavouriteDTO implements Serializable{

    private int favouriteID, commuterID, cityID;
    private long date;
    private String status;

    public FavouriteDTO() {

    }

    public int getFavouriteID() {
        return favouriteID;
    }

    public void setFavouriteID(int favouriteID) {
        this.favouriteID = favouriteID;
    }

    public int getCommuterID() {
        return commuterID;
    }

    public void setCommuterID(int commuterID) {
        this.commuterID = commuterID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
