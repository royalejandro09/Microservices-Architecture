package com.ramv.serieservice.repositorys;

import com.ramv.serieservice.entities.Season;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeasonRepository extends MongoRepository<Season, String> {

}
