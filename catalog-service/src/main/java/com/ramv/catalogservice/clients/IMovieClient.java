package com.ramv.catalogservice.clients;

import com.ramv.catalogservice.dtos.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "movie-service")
public interface IMovieClient {

    @GetMapping("/movie/{genre}")
    List<MovieDTO> getMoviesByGenre(@PathVariable String genre);
}
