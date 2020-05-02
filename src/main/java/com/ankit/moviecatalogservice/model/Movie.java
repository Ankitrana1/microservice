package com.ankit.moviecatalogservice.model;

public class Movie {

    private String movieId;
    private String name;
    private String description;

    public Movie(){}

    public Movie(String movieId, String description) {
        this.movieId = movieId;
        this.description = description;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
