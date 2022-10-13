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
public class SeasonDTO {

    private String id;
    private Integer seasonNumber;
    private List<ChapterDTO> chapters;
}
