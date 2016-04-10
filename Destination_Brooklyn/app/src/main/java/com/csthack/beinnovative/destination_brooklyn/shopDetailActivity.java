package com.csthack.beinnovative.destination_brooklyn;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class shopDetailActivity extends AppCompatActivity {
    private ArrayList<shopClass> shopObjects;
    String namePassed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        Bundle extras = getIntent().getExtras();
        namePassed = getIntent().getExtras().getString("shopname");
        ShopData start = new ShopData();
        shopObjects = start.getShopData();
        int item = getObjectCliked();

    }

    public int getObjectCliked(){
        int a = 0;
        for (int i = 0; i<shopObjects.size(); i++){
            if(shopObjects.get(a).getName().equalsIgnoreCase(namePassed)){
                a = i;
            }
        }
        return a;
    }

}
