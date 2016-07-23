package com.aftarobot.datamigrator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aftarobot.datamigrator.R;
import com.aftarobot.datamigrator.adapters.CityAdapter;
import com.aftarobot.datamigrator.olddata.AdminDTO;
import com.aftarobot.datamigrator.olddata.AssociationDTO;
import com.aftarobot.datamigrator.olddata.CountryDTO;
import com.aftarobot.datamigrator.olddata.DriverDTO;
import com.aftarobot.datamigrator.olddata.DriverProfileDTO;
import com.aftarobot.datamigrator.olddata.LandmarkDTO;
import com.aftarobot.datamigrator.olddata.MarshalDTO;
import com.aftarobot.datamigrator.olddata.ProvinceDTO;
import com.aftarobot.datamigrator.olddata.ResponseDTO;
import com.aftarobot.datamigrator.olddata.RoutePointsDTO;
import com.aftarobot.datamigrator.olddata.VehicleDTO;
import com.aftarobot.datamigrator.util.DataUtil;
import com.aftarobot.datamigrator.util.GeoFireUtil;
import com.aftarobot.datamigrator.util.OldUtil;
import com.aftarobot.library.data.CityDTO;
import com.aftarobot.library.data.OwnerDTO;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    static final String TAG = MainActivity.class.getSimpleName();
    ProgressBar progressBar;
    RecyclerView recycler;
    Snackbar bar;
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        txtTitle = (TextView) findViewById(R.id.titleLabel);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);

        db = FirebaseDatabase.getInstance();
        db.setPersistenceEnabled(true);
        mAuth = FirebaseAuth.getInstance();
        check();

        //getOldLandmarks();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
            }
        });
        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(getApplicationContext(), CityActivity.class);
                startActivity(m);
            }
        });
    }

    List<LandmarkDTO> landmarks;

    HashMap<String, LandmarkDTO> map = new HashMap<>();

    private void getOldLandmarks() {
        OldUtil.getOldLandmarks(new OldUtil.OldListener() {
            @Override
            public void onResponse(ResponseDTO response) {
                if (response.getStatusCode() == 0) {
                    landmarks = response.getLandmarks();
                    for (LandmarkDTO m : landmarks) {
                        map.put(m.getLandmarkName(), m);
                    }
                    Log.d(TAG, "--------------- onResponse: landmarks: " + landmarks.size());
                    DatabaseReference ref = db.getReference(DataUtil.AFTAROBOT_DB)
                            .child(DataUtil.TRIPS);
                }
            }

            @Override
            public void onError(String message) {

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

    private void check() {
        if (mAuth.getCurrentUser() != null) {
            getCities();
            return;
        }
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.i(TAG, "++++++++++++++ onAuthStateChanged:signed_in:" + user.getUid()
                            + " " + user.getEmail());
                    getCities();
                } else {
                    // User needs to sign in
                    Log.e(TAG, "-----------onAuthStateChanged:signed_out - start sign in");
                    //signIn();
                }

            }
        };

        mAuth.addAuthStateListener(mAuthListener);
        signIn();
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
                            getCities();

                        } else {
                            Log.e(TAG, "------------ sign in FAILED");
                            errorBar("Sorry! MPS Sign in has failed. Please try again a bit later");
                        }
                    }
                });
    }

    private List<CityDTO> cities = new ArrayList<>();

    private void getCities() {
        final DatabaseReference citiesRef = db.getReference(DataUtil.AFTAROBOT_DB)
                .child(DataUtil.CITIES);

        Query query = citiesRef.orderByChild("countryID");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cities.clear();
                for (DataSnapshot m : dataSnapshot.getChildren()) {
                    cities.add(m.getValue(CityDTO.class));
                }
                Collections.sort(cities);
                CityAdapter adapter = new CityAdapter(cities, new CityAdapter.CityListener() {
                    @Override
                    public void onNameClicked(CityDTO city) {

                    }

                    @Override
                    public void onNumberClicked(CityDTO city) {

                    }
                });
                LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                recycler.setLayoutManager(lm);
                recycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void getLandmarks(double latitude, double longitude) {
        GeoFireUtil.getLandmarks(latitude, longitude, 3, new GeoFireUtil.StorageListener() {
            @Override
            public void onUploaded(String key) {

            }

            @Override
            public void onError(String message) {

            }
        });
    }

    private void addCityToGeoFire(final CityDTO city) {
        Log.e(TAG, "addCityToGeoFire: landmark: " + city.getName() + ", " + city.getProvinceName());
        GeoFireUtil.addCity(city, new GeoFireUtil.StorageListener() {
            @Override
            public void onUploaded(String key) {
                Log.w(TAG, "++++++++++++++++ onUploaded: landmark on geofire: " + city.getName());
            }

            @Override
            public void onError(String message) {

            }
        });

    }

    public static class CityViewHolder extends RecyclerView.ViewHolder {
        protected TextView name, number;


        public CityViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            number = (TextView) itemView.findViewById(R.id.number);
        }

    }

    private void start() {

        progressBar.setVisibility(View.VISIBLE);

        OldUtil.getOldData(new OldUtil.OldListener() {
            @Override
            public void onResponse(ResponseDTO response) {
                if (response.getStatusCode() == 0) {
                    for (CountryDTO c : response.getCountries()) {
                        Log.w("MainActivity", "onResponse: country: " + c.getName());
                        //write new country from old .....
                        final com.aftarobot.library.data.CountryDTO cx = new com.aftarobot.library.data.CountryDTO();
                        cx.setDate(c.getDate());
                        cx.setName(c.getName());
                        cx.setLatitude(c.getLatitude());
                        cx.setLongitude(c.getLongitude());
                        for (ProvinceDTO p : c.getProvinceList()) {
                            com.aftarobot.library.data.ProvinceDTO px = new com.aftarobot.library.data.ProvinceDTO();
                            px.setName(p.getName());
                            px.setLatitude(p.getLatitude());
                            px.setLongitude(p.getLongitude());
                            px.setStatus(p.getStatus());

                            for (com.aftarobot.datamigrator.olddata.CityDTO z : p.getCityList()) {
                                CityDTO city = new CityDTO();
                                city.setName(z.getName());
                                city.setLatitude(z.getLatitude());
                                city.setLongitude(z.getLongitude());
                                city.setStatus(z.getStatus());

                                for (AssociationDTO a : z.getAssociationList()) {

                                    com.aftarobot.library.data.AssociationDTO ax = new com.aftarobot.library.data.AssociationDTO();
                                    ax.setDate(a.getDate());
                                    ax.setStatus(a.getStatus());
                                    ax.setDescription(a.getDescription());
                                    ax.setCountryName(c.getName());
                                    ax.setPhone(a.getPhone());

                                    for (AdminDTO sd : a.getAdminList()) {
                                        com.aftarobot.library.data.AdminDTO sdx = new com.aftarobot.library.data.AdminDTO();
                                        sdx.setEmail(sd.getEmail());
                                        sdx.setDate(sd.getDate());
                                        sdx.setPassword(sd.getPassword());
                                        if (sd.getEmail() != null)
                                            ax.getAdminList().add(sdx);
                                    }
                                    for (DriverDTO d : a.getDriverList()) {

                                        com.aftarobot.library.data.DriverDTO dx = new com.aftarobot.library.data.DriverDTO();
                                        dx.setName(d.getName());
                                        dx.setEmail(d.getEmail());
                                        dx.setPassword(d.getPassword());
                                        dx.setPhone(d.getPhone());
                                        dx.setStatus(d.getStatus());
                                        dx.setDate(d.getDate());
                                        dx.setSurname(d.getSurname());
                                        if (!d.getDriverProfileList().isEmpty()) {

                                            for (DriverProfileDTO dp : d.getDriverProfileList()) {
                                                com.aftarobot.library.data.DriverProfileDTO dpx = new com.aftarobot.library.data.DriverProfileDTO();
                                                dpx.setDate(dp.getDate());
                                                dpx.setStatus(dp.getStatus());
                                                dpx.setAddress(dp.getAddress());
                                                dpx.setCode(dp.getCode());
                                                dpx.setExpiryDate(dp.getExpiryDate());
                                                dpx.setIdNo(dp.getIdNo());
                                                dpx.setIssueDate(dp.getIssueDate());
                                                dpx.setLicenceNo(dp.getLicenceNo());
                                                dpx.setLicenceRestrictions(dp.getLicenceRestrictions());
                                                dx.getDriverProfileList().add(dpx);
                                            }
                                        }
                                        if (dx.getEmail() != null)
                                            ax.getDriverList().add(dx);
                                    }
                                    for (MarshalDTO sd : a.getMarshalList()) {

                                        com.aftarobot.library.data.MarshalDTO sdx = new com.aftarobot.library.data.MarshalDTO();
                                        sdx.setEmail(sd.getEmail());
                                        sdx.setDate(sd.getDate());
                                        sdx.setPassword(sd.getPassword());
                                        sdx.setName(sd.getName());
                                        sdx.setStatus(sd.getSurname());
                                        sdx.setPhone(sd.getPhone());
                                        if (sdx.getEmail() != null)
                                            ax.getMarshalList().add(sdx);
                                    }
                                    for (VehicleDTO sd : a.getVehicleList()) {
                                        com.aftarobot.library.data.VehicleDTO sdx = new com.aftarobot.library.data.VehicleDTO();
                                        sdx.setDate(sd.getDate());
                                        sdx.setCapacity(sd.getCapacity());
                                        sdx.setDriverName(sd.getDriverName());
                                        sdx.setMake(sd.getMake());
                                        sdx.setDriverPhone(sd.getDriverPhone());
                                        sdx.setPolicyExpiryDate(sd.getPolicyExpiryDate());
                                        sdx.setLicenceExpiryDate(sd.getLicenceExpiryDate());
                                        sdx.setOperatingLicence(sd.getOperatingLicence());
                                        sdx.setVehicleReg(sd.getVehicleReg());
                                        sdx.setModel(sd.getModel());
                                        if (sdx.getOwner() != null) {
                                            OwnerDTO ox = new OwnerDTO();
                                            ox.setDate(sdx.getOwner().getDate());
                                            ox.setName(sdx.getOwner().getName());
                                            ox.setAddress(sdx.getOwner().getAddress());
                                            ox.setEmail(sdx.getOwner().getEmail());
                                            ox.setSurname(sdx.getOwner().getSurname());
                                            ox.setPhone(sdx.getOwner().getPhone());
                                            ox.setIdNo(sdx.getOwner().getIdNo());
                                        }
                                        ax.getVehicleList().add(sdx);
                                    }
                                    for (com.aftarobot.datamigrator.olddata.RouteDTO r : a.getRouteList()) {
                                        com.aftarobot.library.data.RouteDTO rx = new com.aftarobot.library.data.RouteDTO();
                                        rx.setName(r.getName());
                                        rx.setDate(r.getDate());
                                        rx.setStatus(r.getStatus());
                                        for (RoutePointsDTO rp : r.getRoutePoints()) {
                                            com.aftarobot.library.data.RoutePointsDTO rpx = new com.aftarobot.library.data.RoutePointsDTO();
                                            rpx.setStatus(rp.getStatus());
                                            rpx.setLatitude(rp.getLatitude());
                                            rpx.setLongitude(rp.getLongitude());
                                            rpx.setName(rp.getName());

                                            rx.getRoutePointList().add(rpx);
                                        }
                                        for (com.aftarobot.datamigrator.olddata.RouteCityDTO rc : r.getRouteCityList()) {

                                            for (LandmarkDTO l : rc.getLandmarkList()) {
                                                com.aftarobot.library.data.LandmarkDTO lx = new com.aftarobot.library.data.LandmarkDTO();
                                                lx.setLatitude(l.getLatitude());
                                                lx.setLongitude(l.getLongitude());
                                                lx.setCityName(rc.getCityName());
                                                lx.setCityID(rx.getCityID());
                                                lx.setLandmarkName(l.getLandmarkName());
                                                lx.setRouteName(rc.getRouteName());
                                                lx.setStatus(l.getStatus());
                                                lx.setRankSequenceNumber(l.getRankSequenceNumber());
                                                lx.setNumberOfPendingRequests(l.getNumberOfPendingRequests());
                                                lx.setNumberOfWaitingCommuters(l.getNumberOfWaitingCommuters());
                                                lx.setDate(l.getDate());

                                                rx.getLandmarkList().add(lx);
                                            }

                                        }


                                        ax.getRouteList().add(rx);
                                    }

                                    city.getAssociationList().add(ax);
                                }

                                px.getCityList().add(city);
                            }

                            cx.getProvinceList().add(px);
                        }


                        //now pull the trigger
                        DataUtil.deleteDatabase(new DataUtil.DataAddedListener() {
                            @Override
                            public void onResponse(String key) {
                                Log.w(TAG, "onResponse: Database has been deleted");
                                DataUtil.addCountry(cx, new DataUtil.DataAddedListener() {
                                    @Override
                                    public void onResponse(String key) {
                                        Log.d("MainActivity", "\n\n---------------$$$$$$$$$$ BINGO! we look like we done!");
                                        progressBar.setVisibility(View.GONE);
                                    }

                                    @Override
                                    public void onError(String message) {
                                        errorBar(message);
                                        progressBar.setVisibility(View.GONE);
                                    }
                                });
                            }

                            @Override
                            public void onError(String message) {
                                Log.e(TAG, "onError: " + message);
                            }
                        });

                    }
                }
            }

            @Override
            public void onError(String message) {
                progressBar.setVisibility(View.GONE);
                errorBar(message);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
