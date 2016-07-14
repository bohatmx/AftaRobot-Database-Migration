package com.aftarobot.datamigrator.activities;

import android.app.Application;
import android.util.Log;

import com.firebase.client.Firebase;

/**
 * Created by aubreymalabie on 6/3/16.
 */
public class App extends Application {

    static final String TAG = App.class.getSimpleName();

    private boolean haveDetectedBeaconsSinceBoot = false;

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(getApplicationContext());
        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        //FirebaseDatabase.getInstance().setLogLevel(Logger.Level.DEBUG);
        Log.i(TAG,"########################### Migrator App has started: Firebase initialized");

        //  App ID & App Token can be taken from App section of Estimote Cloud.
        // Optional, debug logging.
        //EstimoteSDK.enableDebugLogging(true);
        Log.i(TAG,"########################### Migrator App has started: BeaconManager initialized");

    }


}
