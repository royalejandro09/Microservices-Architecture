package com.ramv.catalogservice.entities;

import com.ramv.catalogservice.dtos.MovieDTO;
import com.ramv.catalogservice.dtos.SerieDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Catalog {

    @Id
    private String id;
    private String genre;
    private List<MovieDTO> moviesDto;
    private List<SerieDTO> seriesDto;

}
