package com.csthack.beinnovative.destination_brooklyn;

import android.app.Activity;
import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.csthack.beinnovative.destination_brooklyn.shopClass;

import java.util.List;

/**
 * Created by Berta on 4/9/2016.
 */
public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private shopClass[] shopObjects;
    //ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, shopClass[] shopObjects) {
        this.activity = activity;
        this.shopObjects = shopObjects;
    }
    @Override
    public int getCount() {
        return shopObjects.length;
    }
    @Override
    public shopClass getItem(int location) {
        return shopObjects[location];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

//        if (imageLoader == null)
//            imageLoader = AppController.getInstance().getImageLoader();
//        NetworkImageView thumbNail = (NetworkImageView) convertView
//                .findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView description = (TextView) convertView.findViewById(R.id.description);
        LinearLayout bkgImage = (LinearLayout) convertView.findViewById(R.id.bkgImage);

        // getting movie data for the row
        shopClass shop = shopObjects[position];
        // bkg image
//        bkgImage.setBackground();

        // title
        title.setText(shop.getName());

        // description
        description.setText(shop.getDescription());
        return convertView;
    }

}