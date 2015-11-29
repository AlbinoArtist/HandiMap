package com.example.henrik.handimap;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Henrik on 2015-11-16.
 */
public class ReviewedBuilding {
    private float medianRating;
    private String streetTownZip;
    private LatLng location;
    private ArrayList<Review> reviews;

    public ReviewedBuilding(String streetTownZip, LatLng location, Review review){

    }
    private void generateMedianRating(){
        Iterator<Review> iterator = reviews.iterator();
        float total = 0;
        while(iterator.hasNext()){
            total += iterator.next().getRating();
        }
        medianRating = total/reviews.size();

    }
}
