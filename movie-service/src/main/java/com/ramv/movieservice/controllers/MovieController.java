package com.ramv.movieservice.controllers;

import com.ramv.movieservice.dtos.MovieDTO;
import com.ramv.movieservice.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final IMovieService movieService;

    @Autowired
    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieDTO> saveMovie(@RequestBody MovieDTO movie) {
        MovieDTO movieResponse = movieService.saveMovie(movie);

        return ResponseEntity.ok(movieResponse);
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<MovieDTO>> findByGenre(@PathVariable String genre) {
        List<MovieDTO> movies = movieService.findByGenre(genre);

        return ResponseEntity.ok(movies);
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();

        return ResponseEntity.ok(movies);
    }
}
