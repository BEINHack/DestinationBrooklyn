package com.csthack.beinnovative.destination_brooklyn;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;

import android.content.Intent;
import android.view.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.csthack.beinnovative.destination_brooklyn.pointInterestClass;

public class MainActivity extends AppCompatActivity
        implements
        OnMyLocationButtonClickListener,
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback {

//    private static final LatLng BRISBANE = new LatLng(-27.47093, 153.0235);
//
//    private static final LatLng MELBOURNE = new LatLng(-37.81319, 144.96298);
//
//    private static final LatLng SYDNEY = new LatLng(-33.87365, 151.20689);
//
//    private static final LatLng ADELAIDE = new LatLng(-34.92873, 138.59995);
//
//    private static final LatLng PERTH = new LatLng(-31.952854, 115.857342);

    /**
     * Request code for location permission request.
     *
     * @see #onRequestPermissionsResult(int, String[], int[])
     */
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    /**
     * Flag indicating whether a requested permission has been denied after returning in
     * {@link #onRequestPermissionsResult(int, String[], int[])}.
     */
    private boolean mPermissionDenied = false;
    private double lat, lon;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
//        POIdata start = new POIdata();
//        pointInterestClass[] myObjects = start.getPOIobjects();
//        int length = myObjects.length;
        //System.out.println(length);


//        String periodSelected = getIntent().getExtras().getString("buildingType");
//        String timeSelected = getIntent().getExtras().getString("TimePeriod");
//        for (int i = 0; i <= length; i++) {
//            lat = myObjects[i].getLatitude();
//            lon = myObjects[i].getLongitude();
//            mMap.addMarker(new MarkerOptions()
//                    .position(new LatLng(lat, lon))
//                    .title(myObjects[i].getName()));
//        }
//
//
//        if (periodSelected.equals(null) && timeSelected.equals(null)) {
//            for (int i = 0; i <= myObjects.length; i++) {
//                lat = myObjects[i].getLatitude();
//                lon = myObjects[i].getLatitude();
//                mMap.addMarker(new MarkerOptions()
//                        .position(new LatLng(lat, lon))
//                        .title(myObjects[i].getName()));
//            }
//        }

    }


    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        mMap.setOnMyLocationButtonClickListener(this);


        POIdata start = new POIdata();
        pointInterestClass[] myObjects = start.getPOIobjects();
        int length = myObjects.length;

//        lat = myObjects[1].getLatitude();
//            lon = myObjects[1].getLongitude();
//            map.addMarker(new MarkerOptions()
//                    .position(new LatLng(lat, lon))
//                    .title(myObjects[1].getName()));



        for (int i = 0; i < length; i++) {
            lat = myObjects[i].getLatitude();
            lon = myObjects[i].getLongitude();
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(lat, lon))
                    .title(myObjects[i].getName()));
        }

        enableMyLocation();
    }

    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    public boolean onMyLocationButtonClick() {
        //Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }

    /**
     * Adding menu bar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent launchActivity = new Intent();
        switch (item.getItemId()) {
            case R.id.filter_id:
                launchActivity = new Intent(this, CategoriesActivity.class);
                break;

            case R.id.store_id:
                launchActivity = new Intent(this, ShopActivity.class);
                break;


            case R.id.centre_id:
                launchActivity = new Intent(this, MainActivity.class);
                break;

            case R.id.search_id:
                Toast.makeText(getApplicationContext(), "Allow user to search a specific address/ subject", Toast.LENGTH_SHORT).show();
                break;
        }
        startActivity(launchActivity);
        return super.onOptionsItemSelected(item);
    }


}