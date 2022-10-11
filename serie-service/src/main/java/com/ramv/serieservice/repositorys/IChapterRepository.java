package com.ramv.serieservice.repositorys;

import com.ramv.serieservice.entities.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChapterRepository extends MongoRepository<Chapter, String> {

}
