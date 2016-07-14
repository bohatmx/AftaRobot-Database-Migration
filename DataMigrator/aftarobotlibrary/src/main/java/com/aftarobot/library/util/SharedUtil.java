package com.aftarobot.library.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.aftarobot.library.data.UserDTO;
import com.google.gson.Gson;

/**
 * Created by aubreymalabie on 7/13/16.
 */

public class SharedUtil {
    public static final String TAG = SharedUtil.class.getSimpleName();
    public static void saveUser(UserDTO user, Context ctx) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("user", gson.toJson(user));
        ed.commit();
        Log.d(TAG, "saveUser: " + user.getEmail());
    }
    public static UserDTO getUser(Context ctx) {

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        String json = sp.getString("user", null);
        if (json == null) {
            return  null;
        }
        return gson.fromJson(json, UserDTO.class);
    }

    private final static Gson gson = new Gson();
}
