/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.library.data;


/**
 *
 * @author Aubrey MalabieKobue
 */
public class PhotoUploadDTO {

    private int photoUploadID, driverID, ownerID, vehicleID, marshalID, landmarkID,
            adminID, commuterID, rankManagerID, pictureType, thumbFlag, width, height, bytes;
    private long dateTaken, dateUploaded;
    private float accuracy;
    private double latitude, longitude;
    private String status, signature, eTag, secureUrl, thumbFilePath, uri, description;

    public PhotoUploadDTO() {
    }

    public int getPhotoUploadID() {
        return photoUploadID;
    }

    public void setPhotoUploadID(int photoUploadID) {
        this.photoUploadID = photoUploadID;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
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

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public int getCommuterID() {
        return commuterID;
    }

    public void setCommuterID(int commuterID) {
        this.commuterID = commuterID;
    }

    public int getRankManagerID() {
        return rankManagerID;
    }

    public void setRankManagerID(int rankManagerID) {
        this.rankManagerID = rankManagerID;
    }

    public int getPictureType() {
        return pictureType;
    }

    public void setPictureType(int pictureType) {
        this.pictureType = pictureType;
    }

    public int getThumbFlag() {
        return thumbFlag;
    }

    public void setThumbFlag(int thumbFlag) {
        this.thumbFlag = thumbFlag;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    public long getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(long dateTaken) {
        this.dateTaken = dateTaken;
    }

    public long getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(long dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String geteTag() {
        return eTag;
    }

    public void seteTag(String eTag) {
        this.eTag = eTag;
    }

    public String getSecureUrl() {
        return secureUrl;
    }

    public void setSecureUrl(String secureUrl) {
        this.secureUrl = secureUrl;
    }

    public String getThumbFilePath() {
        return thumbFilePath;
    }

    public void setThumbFilePath(String thumbFilePath) {
        this.thumbFilePath = thumbFilePath;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
