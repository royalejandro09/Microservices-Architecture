package com.ramv.serieservice.services;

import com.ramv.serieservice.entities.Serie;

import java.util.List;

public interface ISerieService {

    Serie saveSerie(Serie serie);
    List<Serie>  getAllSeries();
    List<Serie> findByGenre(String genre);
}
