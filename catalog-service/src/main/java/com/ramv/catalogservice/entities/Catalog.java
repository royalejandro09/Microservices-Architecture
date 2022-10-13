package com.ramv.catalogservice.entities;

import com.ramv.catalogservice.dtos.MovieDTO;
import com.ramv.catalogservice.dtos.SerieDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Catalog {

    @Id
    private String id;
    private String genre;
    private List<MovieDTO> moviesDto;
    private List<SerieDTO> seriesDto;

}
