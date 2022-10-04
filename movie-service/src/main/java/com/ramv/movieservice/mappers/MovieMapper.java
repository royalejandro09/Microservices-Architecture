package com.ramv.movieservice.mappers;

import com.ramv.movieservice.dtos.MovieDTO;
import com.ramv.movieservice.entities.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Dto to Entity.
     */
    public Movie toEntity(MovieDTO dto) {
        Movie entity = modelMapper.map(dto, Movie.class);

        return entity;
    }

    /**
     * Entity to Dto.
     */
    public MovieDTO toDto(Movie movie) {
        MovieDTO dto = modelMapper.map(movie, MovieDTO.class);

        return dto;
    }

    /**
     * List Dto to List Entity.
     */
    public List<Movie> listToEntity(List<MovieDTO> dtos) {

        List<Movie> entities = dtos
                .stream()
                .map(dto -> toEntity(dto))
                .collect(Collectors.toList());

        return entities;
    }

    /**
     * List Entity to List Dto.
     */
    public List<MovieDTO> listToDto(List<Movie> entities) {

        List<MovieDTO> dtos = entities
                .stream()
                .map(entity -> toDto(entity))
                .collect(Collectors.toList());

        return dtos;
    }

}
