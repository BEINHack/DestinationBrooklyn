package com.csthack.beinnovative.destination_brooklyn;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class CategoriesActivity extends FragmentActivity
        implements OnMapReadyCallback,
        OnClickListener{

    Spinner timeFilter, buildingType;
    String timePeriodSelected, buildingTypeSelected;
    Button btn_filterResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        timeFilter =(Spinner) findViewById(R.id.spinner_TimeFilter);
        buildingType =(Spinner) findViewById(R.id.spinner_BuildingType);
        btn_filterResults = (Button) findViewById(R.id.btn_FilterResults);
        btn_filterResults.setOnClickListener(this);
    }
    public void onClick(View v) {
        timePeriodSelected = timeFilter.getSelectedItem().toString();
        buildingTypeSelected = buildingType.getSelectedItem().toString();
        Intent launchMain = new Intent(this, MainActivity.class);

        // calling an activity using <intent-filter> action name
        //  Intent inent = new Intent("com.hmkcode.android.ANOTHER_ACTIVITY");

        startActivity(launchMain);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
