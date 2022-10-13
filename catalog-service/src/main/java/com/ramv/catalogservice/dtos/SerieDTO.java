package com.ramv.catalogservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SerieDTO {

    private String id;
    private String name;
    private String genre;
    private List<SeasonDTO> seasons;

}
