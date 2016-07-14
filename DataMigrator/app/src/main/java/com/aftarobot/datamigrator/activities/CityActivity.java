package com.aftarobot.datamigrator.activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aftarobot.datamigrator.R;
import com.aftarobot.datamigrator.adapters.CityAdapter;
import com.aftarobot.datamigrator.olddata.ResponseDTO;
import com.aftarobot.datamigrator.util.DataUtil;
import com.aftarobot.datamigrator.util.OldUtil;
import com.aftarobot.library.data.AttachmentDTO;
import com.aftarobot.library.data.CityDTO;
import com.aftarobot.library.data.LandmarkDTO;
import com.aftarobot.library.data.RouteCityDTO;
import com.aftarobot.library.data.RouteDTO;
import com.aftarobot.library.data.TripDTO;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CityActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    GoogleApiClient mGoogleApiClient;
    MessageListener mMessageListener;
    FirebaseDatabase db;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    static final String TAG = CityActivity.class.getSimpleName();
    ProgressBar progressBar;
    RecyclerView recycler;
    TextView title;
    Snackbar bar;
    CityAdapter cityAdapter;
    ValueEventListener eventListener;
    List<CityDTO> cityList = new ArrayList<>();
    HashMap<String, CityDTO> cities = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        title = (TextView) findViewById(R.id.entityTitle);
        title.setText("AftaRobot Cities");
        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(lm);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Nearby.MESSAGES_API)
                .addConnectionCallbacks(this)
                .enableAutoManage(this, this)
                .build();

        db = FirebaseDatabase.getInstance();
        //db.setPersistenceEnabled(true);
        mAuth = FirebaseAuth.getInstance();
        //getOldLandmarks();

        check();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                            }
        });
    }

   
    int count;
    private void getCities() {
        final DatabaseReference citiesRef = db.getReference(DataUtil.AFTAROBOT_DB)
                .child(DataUtil.CITIES);

        Query query = citiesRef.orderByChild("countryID");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onDataChange: addListenerForSingleValueEvent:\n " + dataSnapshot.getChildrenCount());
                for (DataSnapshot m: dataSnapshot.getChildren()) {
                    CityDTO c = m.getValue(CityDTO.class);
                    cities.put(c.getCityID(),c);
                    cityList.add(c);
                    Log.i(TAG, "onDataChange: City received: " + c.getName());

                }
                setCityList();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void setCityList() {
        Collections.sort(cityList);
        cityAdapter = new CityAdapter(cityList, new CityAdapter.CityListener() {
            @Override
            public void onNameClicked(CityDTO city) {
                Log.d(TAG, "........onNameClicked: city: " + city.getName());
                showDialog(city);
            }

            @Override
            public void onNumberClicked(CityDTO city) {
                Log.w(TAG, "onNumberClicked: city: " + city.getName() );
                if (city.getRoutes() != null && !city.getRoutes().isEmpty()) {
                    Intent m = new Intent(getApplicationContext(), RouteActivity.class);
                    m.putExtra("city", city);
                    startActivity(m);
                }
            }
        });
        recycler.setAdapter(cityAdapter);
    }
    private void showDialog(final CityDTO city) {
        AlertDialog.Builder dg = new AlertDialog.Builder(this);
        dg.setTitle("Trip Migrator")
                .setMessage("Do you want to add trips?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addTrips(city);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    private void signIn() {

        Log.w(TAG, "signIn: ================ Firebase signin");
        final String e = "aubrey@mlab.co.za";
        final String p = "kktiger3";

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(e, p)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.i(TAG, "####### signIn: onComplete: " + task.isSuccessful());
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            FirebaseUser user = task.getResult().getUser();
                            Log.i(TAG, "####### onComplete: we cool, name: "
                                    + user.getDisplayName() + " email: " + user.getEmail()
                                    + " uid: " + user.getUid() + " \ntoken: " + user.getToken(true));


                        } else {
                            Log.e(TAG, "------------ sign in FAILED");
                            errorBar("Sorry! MPS Sign in has failed. Please try again a bit later");
                        }
                    }
                });
    }


    private void errorBar(String message) {
        bar = Snackbar.make(progressBar, message, Snackbar.LENGTH_INDEFINITE);
        bar.setActionTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_red_light));
        bar.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar.dismiss();
            }
        });
        bar.show();
    }
    @Deprecated
    private void addTrips(CityDTO city) {


        if (city.getRoutes() != null) {
            for (RouteDTO r: city.getRoutes().values()) {
                if (r.getRouteCities() != null) {
                    for (RouteCityDTO rc: r.getRouteCities().values()) {
                        if (rc.getLandmarks() != null) {
                            for (LandmarkDTO l: rc.getLandmarks().values()) {

                                com.aftarobot.datamigrator.olddata.LandmarkDTO x = map.get(l.getLandmarkName());
                                if (x != null) {
                                    if (!x.getTripList().isEmpty()) {
                                        for (com.aftarobot.datamigrator.olddata.TripDTO t: x.getTripList()) {
                                            TripDTO tx = new TripDTO();
                                            tx.setLandmarkID(l.getLandmarkID());
                                            tx.setLandmarkName(t.getLandmarkName());
                                            tx.setVehicleReg(t.getVehicleReg());
                                            tx.setRouteName(l.getRouteName());
                                            tx.setRouteCityName(l.getRouteCityName());
                                            tx.setCityID(l.getCityID());
                                            tx.setCityName(l.getCityName());
                                            tx.setDateArrived(t.getDateArrived());
                                            tx.setDateDispatched(t.getDateDipatched());
                                            tx.setMarshalName(t.getMarshalName());
                                            tx.setNumberOfPassengers(t.getNumberOfPassengers());
                                            tx.setRouteCityID(l.getRouteCityID());
                                            tx.setAssociatioName(t.getAssociatioName());

                                            DataUtil.addTrip(tx,null);

                                        }
                                    } else {
                                        Log.d(TAG, "addTrips: NO TRIPS");
                                    }
                                }
                            }
                        } else {
                            Log.d(TAG, "addTrips: No landmarks");
                        }
                    }
                } else {
                    Log.d(TAG, "addTrips: No landmark cities");
                }
            }
        } else {
            Log.d(TAG, "addTrips: no ROUTES!!");
        }
    }
    HashMap<String, com.aftarobot.datamigrator.olddata.LandmarkDTO> map = new HashMap<>();
    List<com.aftarobot.datamigrator.olddata.LandmarkDTO> landmarks;
    @Deprecated
    private void getOldLandmarks() {
        OldUtil.getOldLandmarks(new OldUtil.OldListener() {
            @Override
            public void onResponse(ResponseDTO response) {
                if (response.getStatusCode() == 0) {
                    landmarks = response.getLandmarks();
                    for (com.aftarobot.datamigrator.olddata.LandmarkDTO m: landmarks) {
                        map.put(m.getLandmarkName(),m);
                    }
                    Log.d(TAG, "--------------- onResponse: landmarks: " + landmarks.size());
                } else {
                    errorBar(response.getMessage());
                }
            }

            @Override
            public void onError(String message) {
                errorBar(message);
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }


    static final Gson gson = new Gson();
    private AttachmentDTO getAttachment(String json) {
        try {
            AttachmentDTO att = gson.fromJson(json, AttachmentDTO.class);
            if (att != null) {
                Log.i(TAG, "getAttachment: route: " + att.getRouteName()
                        + " landmark: " + att.getLandmarkName()
                        + " city: " + att.getCityName()
                        + " beacon: " + att.getBeaconName());
            }
            return att;
        } catch (JsonSyntaxException e) {
            Log.e(TAG, "getAttachment: ", e );
            Log.d(TAG, "getAttachment: " + json);
        }
        return null;
    }
    @Override
    public void onConnected(Bundle bundle) {
        //subscribeBackground();
        //subscribeForeground();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e(TAG, "onConnectionFailed: " + connectionResult.getErrorMessage());
    }

    private void check() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERM);
            return;
        }

        token = com.aftarobot.datamigrator.util.SharedUtil.getToken(getApplicationContext());
        new RetrieveTokenTask().execute("aubrey@mlab.co.za");

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_LOCATION_PERM:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                }
                break;

        }
    }

    private class RetrieveTokenTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String accountName = params[0];
//            try {
//                token = GoogleAuthUtil.getToken(getApplicationContext(), accountName, SCOPE);
//            } catch (IOException e) {
//                Log.e(TAG, e.getMessage());
//            } catch (UserRecoverableAuthException e) {
//                Log.e(TAG, "doInBackground: UserRecoverableAuthException startActivity");
//                startActivityForResult(e.getIntent(), REQ_SIGN_IN_REQUIRED);
//            } catch (GoogleAuthException e) {
//                Log.e(TAG, e.getMessage());
//            }
            return token;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.e(TAG, "onPostExecute: token: " + s);
            com.aftarobot.datamigrator.util.SharedUtil.saveToken(getApplicationContext(), token);
            getCities();
        }
    }

    String token;
    static final int REQUEST_LOCATION_PERM = 878, REQ_SIGN_IN_REQUIRED = 909;
    private static final String SCOPE = "oauth2:https://www.googleapis.com/auth/userlocation.beacon.registry";


}
