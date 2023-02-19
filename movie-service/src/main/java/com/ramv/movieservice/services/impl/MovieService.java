package com.ramv.movieservice.services.impl;

import com.ramv.movieservice.dtos.MovieDTO;
import com.ramv.movieservice.entities.Movie;
import com.ramv.movieservice.exceptions.MovieNotFoundException;
import com.ramv.movieservice.mappers.MovieMapper;
import com.ramv.movieservice.repositorys.IMovieRepository;
import com.ramv.movieservice.services.IMovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class MovieService implements IMovieService {

    private final MovieMapper mapper;
    @Value("${queue.movie.name}")
    private String movieQueue;
    private RabbitTemplate rabbitTemplate;
    private final IMovieRepository movieRepository;

    @Autowired
    public MovieService(MovieMapper mapper, IMovieRepository movieRepository,
                        RabbitTemplate rabbitTemplate) {
        this.mapper = mapper;
        this.movieRepository = movieRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Save Movie.
     *
     * @param movie
     * @return
     */
    @Transactional
    @Override
    public MovieDTO saveMovie(MovieDTO movie) {

        Movie entity = mapper.toEntity(movie);
        entity.setGenre(entity.getGenre().toLowerCase());

        Movie movieBO = movieRepository.save(entity);
        this.rabbitTemplate.convertAndSend(this.movieQueue, movieBO.getGenre());
        log.info(String.format("The Movie %s was save successfully", movieBO.getName()));
        MovieDTO dto = mapper.toDto(movieBO);
        return dto;
    }

    /**
     * Get Movies by Genre.
     *
     * @param genre
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<MovieDTO> findByGenre(String genre) {
        List<Movie> listMovieResponse = movieRepository.findByGenre(genre.toLowerCase())
                .orElseThrow(() -> new MovieNotFoundException(String.format("The Movie with genre %s Not_Found", genre)));

        return mapper.listToDto(listMovieResponse);
    }

    /**
     * Get all Movies.
     *
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> listMovies = movieRepository.findAll();
        log.info(String.format("Las movies %s ", listMovies));
        return mapper.listToDto(listMovies);
    }
}
