package com.aftarobot.library.data;

import com.aftarobot.library.signin.SignInContract;

/**
 * Created by aubreymalabie on 7/11/16.
 */

public class UserDTO {
    int userType;
    String userID, uid, name, countryID, email, cellphone, password, userDescription, associationID;
    String defaultMorningLandmarkID, defaultAfternoonLandmarkID, defaultRouteID;

    public String getUid() {
        return uid;
    }

    public String getAssociationID() {
        return associationID;
    }

    public void setAssociationID(String associationID) {
        this.associationID = associationID;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDefaultRouteID() {
        return defaultRouteID;
    }

    public void setDefaultRouteID(String defaultRouteID) {
        this.defaultRouteID = defaultRouteID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getDefaultMorningLandmarkID() {
        return defaultMorningLandmarkID;
    }

    public void setDefaultMorningLandmarkID(String defaultMorningLandmarkID) {
        this.defaultMorningLandmarkID = defaultMorningLandmarkID;
    }

    public String getDefaultAfternoonLandmarkID() {
        return defaultAfternoonLandmarkID;
    }

    public void setDefaultAfternoonLandmarkID(String defaultAfternoonLandmarkID) {
        this.defaultAfternoonLandmarkID = defaultAfternoonLandmarkID;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
        switch (userType) {
            case SignInContract.ADMIN:
                userDescription = "Administrator";
                break;
            case SignInContract.MARSHAL:
                userDescription = "Queue Marshal";
                break;
            case SignInContract.DRIVER:
                userDescription = "Driver";
                break;
            case SignInContract.COMMUTER:
                userDescription = "Commuter";
                break;
            case SignInContract.OWNER:
                userDescription = "Owner";
                break;
            case SignInContract.PATROLLER:
                userDescription = "Route Patroller";
                break;

        }
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
