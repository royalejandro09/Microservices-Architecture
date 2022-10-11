package com.ramv.serieservice.services;

import com.ramv.serieservice.entities.Chapter;
import com.ramv.serieservice.entities.Season;
import com.ramv.serieservice.entities.Serie;
import com.ramv.serieservice.repositorys.IChapterRepository;
import com.ramv.serieservice.repositorys.ISeasonRepository;
import com.ramv.serieservice.repositorys.ISerieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SerieSerivice implements ISerieService {

    private final ISerieRepository serieRepository;
    private final ISeasonRepository seasonRepository;
    private final IChapterRepository chapterRepository;

    @Autowired
    public SerieSerivice(ISerieRepository serieRepository, ISeasonRepository seasonRepository, IChapterRepository chapterRepository) {
        this.serieRepository = serieRepository;
        this.seasonRepository = seasonRepository;
        this.chapterRepository = chapterRepository;
    }

    @Override
    public Serie saveSerie(Serie serie) {
        serie.setGenre(serie.getGenre().toLowerCase());

        serie.getSeasons().stream()
                .forEach(s -> s.setChapters(chapterRepository.saveAll(s.getChapters())));

        serie.setSeasons(seasonRepository.saveAll(serie.getSeasons()));
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
