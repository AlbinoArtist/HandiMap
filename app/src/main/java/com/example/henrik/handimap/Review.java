package com.example.henrik.handimap;

/**
 * Created by Henrik on 2015-11-16.
 */
public class Review {
    private float rating;
    private String creator;
    private String description;

    public Review(float rating, String creator, String description){
        this.rating = rating;
        this.creator = creator;
        this.description = description;
    }

    public float getRating() {
        return rating;
    }
    public String getCreator(){
        return creator;
    }
    public String getDescription(){
        return description;
    }
}
