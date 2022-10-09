package com.ramv.serieservice.services;

import com.ramv.serieservice.entities.Serie;
import com.ramv.serieservice.repositorys.ISerieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SerieSerivice implements ISerieService {

    private final ISerieRepository serieRepository;

    @Autowired
    public SerieSerivice(ISerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public Serie saveSerie(Serie serie) {
        Serie response = serieRepository.save(serie);
        log.info(String.format("The %s series has been successfully saved!", serie.getName()));
        return response;
    }

    @Override
    public List<Serie> findByGenre(String genre) {
        List<Serie> response = serieRepository.findByGenre(genre).get();
        return response;
    }
}
