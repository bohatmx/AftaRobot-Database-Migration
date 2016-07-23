package com.aftarobot.datamigrator.util;

import android.util.Log;

import com.aftarobot.library.data.CityDTO;
import com.aftarobot.library.data.LandmarkDTO;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.firebase.geofire.GeoQueryEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.regex.Pattern;

/**
 * Created by aubreymalabie on 5/25/16.
 */
public class GeoFireUtil {

    public interface StorageListener {
        void onUploaded(String key);

        void onError(String message);
    }

    //
    static final String STORAGE_URL = "gs://aftarobot-2016-dev.appspot.com/",
            TAG = GeoFireUtil.class.getSimpleName();

    static FirebaseStorage storage;
    static FirebaseDatabase db;

    static final String GEOFIRE_URL = "https://aftarobot-2016-dev.firebaseio.com/locations",
            AT = "@";

    public static void addLandmark(final LandmarkDTO landmark, final StorageListener listener) {

        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        GeoFire geo = new GeoFire(new Firebase(GEOFIRE_URL + "/landmarks"));
        StringBuilder sb = new StringBuilder();
        sb.append(stripBlanks(landmark.getCityID()));
        sb.append(AT).append(stripBlanks(landmark.getRouteID()));
        sb.append(AT).append(stripBlanks(landmark.getLandmarkID()));
        String key = sb.toString();

        geo.setLocation(key, new GeoLocation(landmark.getLatitude(), landmark.getLongitude()),
                new GeoFire.CompletionListener() {
                    @Override
                    public void onComplete(String key, FirebaseError error) {
                        if (error == null) {
                            Log.d(TAG, "********* onComplete: geofire landmark saved: " + landmark.getLandmarkName() + " \nkey: " + key);
                            if (listener != null)
                                listener.onUploaded(key);
                        } else {
                            if (listener != null)
                                listener.onError("Unable to add landmark to Geofire");
                        }

                    }
                });
    }
    public static void addCity(final CityDTO city, final StorageListener listener) {

        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        final GeoFire geo = new GeoFire(new Firebase(GEOFIRE_URL + "/cities"));
        StringBuilder sb = new StringBuilder();
        sb.append(stripBlanks(city.getCityID()));
        String key = sb.toString();
        geo.setLocation(key, new GeoLocation(city.getLatitude(), city.getLongitude()),
                new GeoFire.CompletionListener() {
                    @Override
                    public void onComplete(String key, FirebaseError error) {
                        if (error == null) {
                            Log.d(TAG, "********* onComplete: geofire city saved: " + city.getName() + ", " + city.getProvinceName() + " " + key);


                        } else {
                            if (listener != null)
                                listener.onError("Unable to add city to Geofire");
                        }

                    }
                });
    }

    public static void getLandmarks(double latitude, double longitude, double radius, StorageListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        GeoLocation loc = new GeoLocation(latitude,longitude);
        final GeoFire geo = new GeoFire(new Firebase(GEOFIRE_URL + "/landmarks"));
        GeoQuery q = geo.queryAtLocation(loc, radius);
        q.addGeoQueryEventListener(new GeoQueryEventListener() {
            @Override
            public void onKeyEntered(String key, GeoLocation location) {
                Log.e(TAG, "onKeyEntered: " + key + " lat: " + location.latitude + " lng: " + location.longitude);
                Pattern patt = Pattern.compile("@");


                String[] result = patt.split(key);
                DatabaseReference ref = db.getReference(DataUtil.AFTAROBOT_DB)
                        .child(DataUtil.CITIES).child(result[0])
                        .child(DataUtil.ROUTES).child(result[1])
                        .child(DataUtil.LANDMARKS).child(result[2]);
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        LandmarkDTO m = dataSnapshot.getValue(LandmarkDTO.class);
                        Log.i(TAG, "onDataChange: landmark located: " + m.getLandmarkName());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }

            @Override
            public void onKeyExited(String key) {

            }

            @Override
            public void onKeyMoved(String key, GeoLocation location) {

            }

            @Override
            public void onGeoQueryReady() {

            }

            @Override
            public void onGeoQueryError(FirebaseError error) {

            }
        });
    }

    private static String stripBlanks(String s) {
        return s.replaceAll("\\s+","");
    }


}
