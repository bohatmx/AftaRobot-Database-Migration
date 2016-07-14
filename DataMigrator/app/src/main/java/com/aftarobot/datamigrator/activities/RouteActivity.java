package com.aftarobot.datamigrator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aftarobot.datamigrator.R;
import com.aftarobot.datamigrator.adapters.RouteAdapter;
import com.aftarobot.library.data.CityDTO;
import com.aftarobot.library.data.RouteDTO;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RouteActivity extends AppCompatActivity {
    FirebaseDatabase db;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    static final String TAG = RouteActivity.class.getSimpleName();
    ProgressBar progressBar;
    RecyclerView recycler;
    TextView title;
    Snackbar bar;
    RouteAdapter routeAdapter;
    ValueEventListener eventListener;
    List<RouteDTO> routeList = new ArrayList<>();
    CityDTO city;
    HashMap<String, CityDTO> cities = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        title = (TextView) findViewById(R.id.entityTitle);
        city = (CityDTO)getIntent().getSerializableExtra("city");
        title.setText("Routes - " + city.getName());
        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(lm);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);


        setCityList();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setCityList() {

        for (RouteDTO o: city.getRoutes().values()) {
            routeList.add(o);
        }
        Collections.sort(routeList);
        routeAdapter = new RouteAdapter(routeList, new RouteAdapter.RouteListener() {
            @Override
            public void onNameClicked(RouteDTO route) {
                Log.d(TAG, "onNameClicked: routeCity: " + route.getName());
//                if (route.getRouteCities() != null && !route.getRouteCities().isEmpty()) {
//                    Intent m = new Intent(getApplicationContext(), GenericGeofenceActivity.class);
//                    m.putExtra("route", route);
//                    startActivity(m);
//                }
            }

            @Override
            public void onNumberClicked(RouteDTO route) {
                Log.d(TAG, "onNumberClicked: routeCity: " + route.getName());
                if (route.getRouteCities() != null && !route.getRouteCities().isEmpty()) {
                    Intent m = new Intent(getApplicationContext(), RouteCityActivity.class);
                    m.putExtra("routeCity", route);
                    startActivity(m);
                }
            }
        });
        recycler.setAdapter(routeAdapter);
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

}
