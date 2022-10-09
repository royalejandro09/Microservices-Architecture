package com.ramv.serieservice.repositorys;

import com.ramv.serieservice.entities.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISerieRepository extends MongoRepository<Serie, String> {

    Optional<List<Serie>> findByGenre(String genre);
}
