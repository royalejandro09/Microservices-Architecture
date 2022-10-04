package com.ramv.movieservice.service;

import com.ramv.movieservice.entities.Movie;
import com.ramv.movieservice.exceptions.MovieNotFoundException;
import com.ramv.movieservice.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final IMovieRepository movieRepository;

    @Autowired
    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Save Movie.
     *
     * @param movie
     * @return
     */
    public Movie ssaveMovie(Movie movie) {
        Movie movieBO = movieRepository.save(movie);

        return movieBO;
    }

    /**
     * Get Movies by Genre.
     *
     * @param genre
     * @return
     */
    public List<Movie> findByGenre(String genre) {
        List<Movie> listMovieResponse = movieRepository.findByGenre(genre)
                .orElseThrow(() -> new MovieNotFoundException(String.format("The Movie with genre %s Not_Found", genre)));

        return listMovieResponse;
    }

    /**
     * Get all Movies.
     *
     * @return
     */
    public List<Movie> getAllMovies() {
        List<Movie> listMovies = movieRepository.findAll();

        return listMovies;
    }
}
