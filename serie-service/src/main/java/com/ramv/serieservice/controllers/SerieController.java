package com.ramv.serieservice.controllers;

import com.ramv.serieservice.entities.Serie;
import com.ramv.serieservice.services.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serie")
public class SerieController {

    private final ISerieService serieSerive;

    @Autowired
    public SerieController(ISerieService serieSerive) {
        this.serieSerive = serieSerive;
    }

    @PostMapping
    public ResponseEntity<Serie> saveSerie(@RequestBody Serie serie) {
        Serie response = serieSerive.saveSerie(serie);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Serie>> getAllSeries() {
        List<Serie> series = serieSerive.getAllSeries();
        return ResponseEntity.ok(series);
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Serie>> findByGenre(@PathVariable String genre) {
        String formatGenre = genre.toLowerCase();
        List<Serie> response = serieSerive.findByGenre(formatGenre);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
