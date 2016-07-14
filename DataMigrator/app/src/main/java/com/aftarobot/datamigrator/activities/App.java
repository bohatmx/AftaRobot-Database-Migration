package com.aftarobot.datamigrator.activities;

import android.app.Application;
import android.util.Log;

import com.firebase.client.Firebase;

/**
 * Created by aubreymalabie on 6/3/16.
 */
public class App extends Application {

    static final String TAG = App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(getApplicationContext());
        Log.i(TAG,"########################### Migrator App has started: Firebase initialized");

    }


}
