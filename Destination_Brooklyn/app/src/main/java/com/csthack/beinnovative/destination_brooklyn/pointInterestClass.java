package com.csthack.beinnovative.destination_brooklyn;

/**
 * Created by nolan on 4/9/16.
 */
public class pointInterestClass {

    private String name, imageURL, description, website;
    private double latitude, longitude;

    private void setName(String name){
        this.name = name;
    }

    private String getName(){
        return this.name;
    }

    private void setImageURL(String imageURL){
        this.imageURL = imageURL;
    }

    private String getImageURL(){
        return this.imageURL;
    }

    private void setDescription(String description){
        this.description = description;
    }

    private String getDescription(){
        return this.description;
    }

    private void setWebsite(String website){
        this.website = website;
    }

    private String getWebsite(){
        return this.website;
    }

    private void setLatitude(double latitude){
        this.latitude = latitude;
    }

    private double getLatitude(){
        return this.latitude;
    }

    private void getLongitude(double longitude){
        this.longitude = longitude;
    }

    private double getLongitude(){
        return this.longitude;
    }
}
