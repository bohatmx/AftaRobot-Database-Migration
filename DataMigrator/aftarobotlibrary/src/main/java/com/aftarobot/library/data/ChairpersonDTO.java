/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.library.data;

import java.io.Serializable;

/**
 *
 * @author Aubrey Malabie
 */
public class ChairpersonDTO implements Serializable{

    private int chairpersonID, associationID;
    private String gcmID, name, surname, email, phone, password, status;
    private long date;

    public ChairpersonDTO() {

    }

    public int getChairpersonID() {
        return chairpersonID;
    }

    public void setChairpersonID(int chairpersonID) {
        this.chairpersonID = chairpersonID;
    }

    public int getAssociationID() {
        return associationID;
    }

    public void setAssociationID(int associationID) {
        this.associationID = associationID;
    }

    public String getGcmID() {
        return gcmID;
    }

    public void setGcmID(String gcmID) {
        this.gcmID = gcmID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
