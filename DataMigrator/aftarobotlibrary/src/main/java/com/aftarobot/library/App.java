package com.aftarobot.library;

/**
 * Created by aubreymalabie on 7/13/16.
 */

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.firebase.client.Firebase;
import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

/**
 * Created by aubreymalabie on 7/11/16.
 */

public class App  extends Application {
    static final String TAG = App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(getApplicationContext());
    }

    private static DB snappyDB;
    public  static DB getSnappyDB(Context ctx) {
        try {
            if (snappyDB == null || !snappyDB.isOpen()) {
                snappyDB = DBFactory.open(ctx);
            }
        } catch (SnappydbException e) {
            Log.e(TAG, "getSnappyDB: ", e );
        }

        return snappyDB;
    }
}

