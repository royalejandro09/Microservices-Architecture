package com.ramv.movieservice.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MovieDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    private String name;

    private String genre;

    private String urlStream;
}
