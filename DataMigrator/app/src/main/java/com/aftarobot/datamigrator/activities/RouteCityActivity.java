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
import com.aftarobot.datamigrator.adapters.RouteCityAdapter;
import com.aftarobot.library.data.RouteCityDTO;
import com.aftarobot.library.data.RouteDTO;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RouteCityActivity extends AppCompatActivity {
    FirebaseDatabase db;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    static final String TAG = RouteCityActivity.class.getSimpleName();
    ProgressBar progressBar;
    RecyclerView recycler;
    TextView title;
    Snackbar bar;
    RouteCityAdapter routeCityAdapter;
    List<RouteCityDTO> routeCities = new ArrayList<>();
    RouteDTO route;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        title = (TextView) findViewById(R.id.entityTitle);
        route = (RouteDTO) getIntent().getSerializableExtra("routeCity");
        title.setText("Route Cities - " + route.getName());
        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(lm);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);


        setRouteCityList();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setRouteCityList() {

        for (RouteCityDTO o: route.getRouteCities().values()) {
            routeCities.add(o);
        }
        Collections.sort(routeCities);
        routeCityAdapter = new RouteCityAdapter(routeCities, new RouteCityAdapter.RouteCityListener() {
            @Override
            public void onNameClicked(RouteCityDTO city) {
                Log.d(TAG, "onNameClicked: city: " + city.getCityName());
            }

            @Override
            public void onNumberClicked(RouteCityDTO city) {
                Log.d(TAG, "onNumberClicked: city: " + city.getCityName());
                if (city.getLandmarks() != null && !city.getLandmarks().isEmpty()) {
                    Intent m = new Intent(getApplicationContext(), LandmarkActivity.class);
                    m.putExtra("routeCity", city);
                    startActivity(m);
                }
            }
        });

        recycler.setAdapter(routeCityAdapter);
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
