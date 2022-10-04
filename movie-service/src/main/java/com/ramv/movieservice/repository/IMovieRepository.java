package com.ramv.movieservice.repository;

import com.ramv.movieservice.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IMovieRepository extends JpaRepository<Movie, Long> {

    Optional<List<Movie>> findByGenre(String genre);
}
