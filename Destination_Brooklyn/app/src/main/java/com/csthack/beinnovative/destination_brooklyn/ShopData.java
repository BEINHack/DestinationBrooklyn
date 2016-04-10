package com.csthack.beinnovative.destination_brooklyn;
import com.csthack.beinnovative.destination_brooklyn.shopClass;
/**
 * Created by Berta on 4/9/2016.
 */
public class ShopData {
    private shopClass[] shopObjects;

    ShopData(){

        shopClass shop1 = new shopClass("Bridge Coffee Shop ",
                "http://s3-media2.fl.yelpcdn.com/bphoto/rCH8RPxvzNRJCO66vqE1-A/o.jpg",
                "Low priced local coffee shop which provides a robust menu of Latin American foods and drinks. Great place to get a traditional Latino meal with a Brooklyn touch",
                "http://www.yelp.com/biz/bridge-coffee-shop-new-york",
                40.702238,
                -73.984472);

        shopClass shop2 = new shopClass("Tutt Heights",
                "https://s-media-cache-ak0.pinimg.com/736x/d6/77/d3/d677d329f38492b41e02a36b34420274.jpg",
                "Tasty middle eastern cafe with a relatively cheap priced menu. Perfect if you're in a rush to grab a bite or to sit down outside and take in the environment.",
                "http://www.tuttcafe.com/menu.html",
                40.700202,
                -73.993280);

        shopClass shop3 = new shopClass("Rocco and Jezebel for Pets",
                "http://www.zoespremium.com/wp-content/uploads/2012/07/RoccoJezebel.jpg",
                "Knowledgeable, friendly, family run business which provides everything you'd ever need for your best furry little friend. Great place to get treats, toys, and grooming!",
                "http://www.roccoandjezebel.com/",
                40.698032,
                -73.992235);

        shopClass shop4 = new shopClass("Vineapple Cafe",
                "http://www.socialebk.com/uploads/2/6/4/0/26405878/3351016.jpg",
                "Fantastic atmosphere. Perfect to sit down, have a cup of coffee, and catch up with friends.",
                "http://www.socialebk.com/",
                40.698709,
                -73.992633);
        shopClass shop5 = new shopClass("Rocco's Taco's ",
                "http://orangeappeal.com/wp-content/uploads/2012/10/Rocco2-719x385.jpg",
                " Unique atmosphere and great seating. Service is quick most of the time and the food presentation is great. Prices are decent for the food.",
                "http://www.roccostacos.com/",
                40.693204,
                -73.988411);


        shopObjects = new shopClass[] {shop1, shop2, shop3,shop4,shop5};
    }

    public shopClass[] getShopData(){
        return shopObjects;
    }
}
