package com.csthack.beinnovative.destination_brooklyn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

public class CategoriesActivity extends AppCompatActivity
        implements OnMapReadyCallback,
        OnClickListener{

    Spinner timeFilter, buildingType;
    String timePeriodSelected, buildingTypeSelected;
    Button btn_filterResults, btn_Popular;
    Boolean isPopularOn = false, blackPressed = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        timeFilter =(Spinner) findViewById(R.id.spinner_TimeFilter);
        buildingType =(Spinner) findViewById(R.id.spinner_BuildingType);
        btn_filterResults = (Button) findViewById(R.id.btn_FilterResults);
        btn_Popular = (Button) findViewById(R.id.btn_Popular);
        btn_Popular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (blackPressed == true){
                    btn_Popular.setBackground(getResources().getDrawable(R.drawable.button_boarder));
                    btn_Popular.setTextColor(Color.parseColor("#474C55"));
                    isPopularOn = false;
                    blackPressed = false;
                } else {
                    btn_Popular.setBackgroundColor(Color.parseColor("#474C55"));
                    btn_Popular.setTextColor(Color.parseColor("#FFFFFF"));
                    blackPressed = true;
                    isPopularOn = true;
                }
            }
        });
        btn_filterResults.setOnClickListener(this);
    }
    public void onClick(View v) {
        timePeriodSelected = timeFilter.getSelectedItem().toString();
        buildingTypeSelected = buildingType.getSelectedItem().toString();
        Intent launchMain = new Intent(this, MainActivity.class);
        launchMain.putExtra("TimePeriod", timePeriodSelected);
        launchMain.putExtra("buildingType", buildingTypeSelected);
        launchMain.putExtra("Popular", isPopularOn);
        startActivity(launchMain);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    /**
     * Adding menu bar
     */
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent launchActivity = new Intent();
        switch (item.getItemId()){
            case R.id.filter_id:
                launchActivity = new Intent(this, CategoriesActivity.class);
                break;

            case R.id.store_id:
                launchActivity = new Intent(this, ShopActivity.class);
                break;
            case R.id.centre_id:
                launchActivity = new Intent(this, MainActivity.class);
                launchActivity.putExtra("buildingType", "");
                launchActivity.putExtra("TimePeriod", "");
                break;
            case R.id.search_id:
                Toast.makeText(getApplicationContext(),"Allow user to search a specific address/ subject", Toast.LENGTH_SHORT).show();
                break;
        }
        startActivity(launchActivity);
        return super.onOptionsItemSelected(item);
    }

}
