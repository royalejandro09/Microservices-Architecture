package com.ramv.catalogservice.repository;

import com.ramv.catalogservice.entities.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog, String> {

    Optional<Catalog> findByGenre(String genre);
}
