package com.aftarobot.datamigrator.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.aftarobot.library.data.AssociationDTO;
import com.aftarobot.library.data.DriverDTO;
import com.aftarobot.library.data.VehicleDTO;
import com.google.gson.Gson;

/**
 * Created by aubreymalabie on 6/11/16.
 */
public class SharedUtil {

    static final String TOKEN = "token",
            ASSOC = "assoc", VEHICLE = "vehicle", DRIVER = "driver", TRACKER = "tracker",
            TAG = SharedUtil.class.getSimpleName();
    static final Gson gson = new Gson();
    public static void saveDriver(Context ctx, DriverDTO driver) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor ed = sp.edit();
        String json = gson.toJson(driver);
        ed.putString(DRIVER, json);
        ed.commit();
        Log.w(TAG, "saveDriver");

    }
    public static DriverDTO getDriver(Context ctx) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        String json = sp.getString(DRIVER,null);
        if (json == null) {
            return null;
        }

        DriverDTO a = gson.fromJson(json,DriverDTO.class);
        Log.w(TAG, "getDriver retrieved");
        return a;
    }
    public static void saveVehicle(Context ctx, VehicleDTO vehicle) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor ed = sp.edit();
        String json = gson.toJson(vehicle);
        ed.putString(VEHICLE, json);
        ed.commit();
        Log.w(TAG, "saveVehicle");

    }
    public static VehicleDTO getVehicle(Context ctx) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        String json = sp.getString(VEHICLE,null);
        if (json == null) {
            return null;
        }

        VehicleDTO a = gson.fromJson(json,VehicleDTO.class);
        Log.w(TAG, "getVehicle retrieved");
        return a;
    }
    public static void saveAssociation(Context ctx, AssociationDTO assoc) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor ed = sp.edit();
        String json = gson.toJson(assoc);
        ed.putString(ASSOC, json);
        ed.commit();
        Log.w(TAG, "saveAssociation:");

    }
    public static AssociationDTO getAssociation(Context ctx) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        String json = sp.getString(ASSOC,null);
        if (json == null) {
            return null;
        }

        AssociationDTO a = gson.fromJson(json,AssociationDTO.class);
        Log.w(TAG, "getAssociation: retrieved");
        return a;
    }

    public static void saveToken(Context ctx, String token) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor ed = sp.edit();

        ed.putString(TOKEN, token);
        ed.commit();
        Log.w(TAG, "saveToken: token saved");

    }

    public static String getToken(Context ctx) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        String token = sp.getString(TOKEN, null);
        if (token != null)
            Log.w(TAG, "getToken: token retrieved");

        return token;

    }

}
