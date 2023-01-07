package com.ramv.catalogservice.service.impl;

import com.ramv.catalogservice.clients.IMovieClient;
import com.ramv.catalogservice.clients.ISerieClient;
import com.ramv.catalogservice.entities.Catalog;
import com.ramv.catalogservice.exceptions.CatalogNotFoundException;
import com.ramv.catalogservice.repository.ICatalogRepository;
import com.ramv.catalogservice.service.ICatalogService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public List<Catalog> fidAllCatalogs() {
        List<Catalog> catalogs = catalogRepository.findAll();
        return catalogs;
    }

    @Override
    @CircuitBreaker(name="catalog", fallbackMethod = "findCatalogByGenreFallback")
    public Catalog findCatalogByGenre(String genre) throws CatalogNotFoundException {
        Optional<Catalog> foundCatalog = catalogRepository.findByGenre(genre.toLowerCase());
        return foundCatalog.isPresent() ? foundCatalog.get() :
                foundCatalog.orElseThrow(() -> new CatalogNotFoundException(
                        String.format("Catalog with genre %s not found", genre.toLowerCase())));
    }

    private Catalog findCatalogByGenreFallback(CallNotPermittedException exception){
       Optional<Catalog> catalogUps = catalogRepository.findByGenre("fail");

       if (catalogUps.isPresent()){
           return catalogUps.get();
       }else{
           Catalog catalog = new Catalog();
           catalog.setId("Ups");
           catalog.setGenre("fail");
           catalog.setMoviesDto(new ArrayList<>());
           catalog.setSeriesDto(new ArrayList<>());
           catalogRepository.save(catalog);
           return catalog;
       }
    }

    @RabbitListener(queues = "${queue.movie.name}")
    public void consumeMovieMessage(String message){
        log.info(String.format("Genre movie update: " + message));

        Optional<Catalog> foundCatalog = this.catalogRepository.findByGenre(message);

        if(foundCatalog.isPresent()){
            foundCatalog.get().setMoviesDto(this.movieClient.getMoviesByGenre(message));
            this.catalogRepository.save(foundCatalog.get());
            log.info(String.format("Catalog movie with genre %s update", message));
        }else{
            Catalog catalog = new Catalog();
            catalog.setGenre(message);
            catalog.setMoviesDto(this.movieClient.getMoviesByGenre(message));
            this.catalogRepository.save(catalog);
            log.info(String.format("Catalog movie with genre %s created", message));
        }
    }

    @RabbitListener(queues = "${queue.serie.name}")
    public void consumeSerieMessage(String message){
        System.out.println("Genre serie update: " + message);

        Optional<Catalog> foundCatalog = this.catalogRepository.findByGenre(message);

        if(foundCatalog.isPresent()){
            foundCatalog.get().setSeriesDto(this.serieClient.getSerieByGenre(message));
            this.catalogRepository.save(foundCatalog.get());
            log.info(String.format("Catalog serie with genre %s update", message));
        }else{
            Catalog catalog = new Catalog();
            catalog.setGenre(message);
            catalog.setSeriesDto(this.serieClient.getSerieByGenre(message));
            this.catalogRepository.save(catalog);
            log.info(String.format("Catalog serie with genre %s created", message));
        }
    }
}
