package com.ramv.movieservice.services;

import com.ramv.movieservice.dtos.MovieDTO;
import com.ramv.movieservice.entities.Movie;

import java.util.List;

public interface IMovieService {

    public MovieDTO saveMovie(MovieDTO movie);

    public List<MovieDTO> findByGenre(String genre);

    public List<MovieDTO> getAllMovies();
}
