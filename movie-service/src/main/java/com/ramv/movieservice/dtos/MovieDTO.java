package com.ramv.movieservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Long id;

    private String name;

    private String genre;

    private String urlStream;
}
