package com.ankit.moviecatalogservice.resources;

import com.ankit.moviecatalogservice.model.CatalogItem;
import com.ankit.moviecatalogservice.service.IMovieCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    IMovieCatalogService movieCatalogService;

    @GetMapping(value = "/user/{userId}", produces = "application/json")
    public ResponseEntity<List<CatalogItem>> getCatalog(@PathVariable String userId){
        return ResponseEntity.ok().body(movieCatalogService.getCatalogItemForUser(userId));
    }
}
