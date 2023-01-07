package com.ramv.catalogservice.service;

import com.ramv.catalogservice.entities.Catalog;
import com.ramv.catalogservice.exceptions.CatalogNotFoundException;

import java.util.List;

public interface ICatalogService {

    List<Catalog> fidAllCatalogs();
    Catalog findCatalogByGenre(String genre) throws CatalogNotFoundException;
}
