package com.aftarobot.library.data;

/**
 * Created by admin on 2015/01/29.
 */
public class SearchVehicleDTO {
    private int vehicleID;
    private String reg;

    public SearchVehicleDTO() {
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }
}
