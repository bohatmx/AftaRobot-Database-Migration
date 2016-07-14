package com.aftarobot.library.data;

/**
 * Created by admin on 2015/01/28.
 */
public class TripAdapterDTO {
    private VehicleDTO vehicle;
    private TripDTO trip;

    public TripAdapterDTO() {
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    public TripDTO getTrip() {
        return trip;
    }

    public void setTrip(TripDTO trip) {
        this.trip = trip;
    }
}
