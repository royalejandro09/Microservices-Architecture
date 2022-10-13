package com.ramv.catalogservice.service;

import com.ramv.catalogservice.entities.Catalog;
import com.ramv.catalogservice.exceptions.CatalogNotFoundException;

public interface ICatalogService {

    Catalog findCatalogByGenre(String genre) throws CatalogNotFoundException;
}
