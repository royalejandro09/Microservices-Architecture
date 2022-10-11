package com.ramv.serieservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class Chapter {

    @Id
    private String id;
    private String name;
    private int number;
    private String urlStream;
}

