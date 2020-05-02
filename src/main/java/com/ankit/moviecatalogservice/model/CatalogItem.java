package com.ankit.moviecatalogservice.model;

public class CatalogItem {

    private String userId;
    private String movieName;
    private String rating;

    public CatalogItem(String movieName, String rating) {
        this.movieName = movieName;
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
