package com.ankit.moviecatalogservice.service.impl;

import com.ankit.moviecatalogservice.model.CatalogItem;
import com.ankit.moviecatalogservice.model.Movie;
import com.ankit.moviecatalogservice.model.Rating;
import com.ankit.moviecatalogservice.model.UserRating;
import com.ankit.moviecatalogservice.service.IMovieCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieCatalogService implements IMovieCatalogService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<CatalogItem> getCatalogItemForUser(String userId){

        //RestTemplate restTemplate = new RestTemplate(); Waste to create template for every request hence make as bean(singleton)

        //used a wrap around object for list
        UserRating ratings = restTemplate.getForObject("http://rating-data-service/rating/user/"+userId, UserRating.class);
        //List<Rating> = restTemplate.getForObject("http://localhost:8083/rating/user/asd", ParameterizedTypeReference(List<Rating>));
        return ratings.getRatings().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movie/"+ rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(),rating.getRating());
        }).collect(Collectors.toList());

        //new CatalogItem("124","Shutter Island","8")
    }
}
