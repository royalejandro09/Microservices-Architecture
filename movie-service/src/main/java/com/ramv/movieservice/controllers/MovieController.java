package com.ramv.movieservice.controllers;

import com.ramv.movieservice.dtos.MovieDTO;
import com.ramv.movieservice.entities.Movie;
import com.ramv.movieservice.mappers.MovieMapper;
import com.ramv.movieservice.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final IMovieService movieService;

    @Autowired
    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    public ResponseEntity<MovieDTO> saveMovie(MovieDTO movie) {
        MovieDTO movieResponse = movieService.saveMovie(movie);

        return ResponseEntity.ok(movieResponse);
    }

    public ResponseEntity<List<MovieDTO>> findByGenre(String genre) {
        List<MovieDTO> movies = movieService.findByGenre(genre);

        return ResponseEntity.ok(movies);
    }

    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();

        return ResponseEntity.ok(movies);
    }
}
