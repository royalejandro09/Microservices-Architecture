package com.ramv.serieservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class Season {

    @Id
    private String id;
    private int seasonNumber;
    @DBRef
    private List<Chapter> chapters;
}
