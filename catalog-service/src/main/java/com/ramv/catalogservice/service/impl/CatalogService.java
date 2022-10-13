package com.ramv.catalogservice.service.impl;

import com.ramv.catalogservice.clients.IMovieClient;
import com.ramv.catalogservice.clients.ISerieClient;
import com.ramv.catalogservice.entities.Catalog;
import com.ramv.catalogservice.exceptions.CatalogNotFoundException;
import com.ramv.catalogservice.repository.ICatalogRepository;
import com.ramv.catalogservice.service.ICatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CatalogService implements ICatalogService {

    private final IMovieClient movieClient;
    private final ISerieClient serieClient;
    private final ICatalogRepository catalogRepository;

    @Autowired
    public CatalogService(IMovieClient movieClient, ISerieClient serieClient, ICatalogRepository catalogRepository) {
        this.movieClient = movieClient;
        this.serieClient = serieClient;
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Catalog findCatalogByGenre(String genre) throws CatalogNotFoundException {
        Optional<Catalog> foundCatalog = catalogRepository.findByGenre(genre.toLowerCase());
        return foundCatalog.isPresent() ? foundCatalog.get() :
                foundCatalog.orElseThrow(() -> new CatalogNotFoundException(
                        String.format("Catalog with genre %s not found", genre.toLowerCase())));
    }
}
