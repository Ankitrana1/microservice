package com.ankit.moviecatalogservice.service;

import com.ankit.moviecatalogservice.model.CatalogItem;

import java.util.List;

public interface IMovieCatalogService {

    List<CatalogItem> getCatalogItemForUser(String userId);
}
