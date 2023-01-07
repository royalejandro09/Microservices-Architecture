package com.digitalhouse.apigateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @CircuitBreaker(name = "movieService")
    @GetMapping("/movie")
    public ResponseEntity<String> moviesFallback() {
        return new ResponseEntity<>("Servidor de movies no está disponible actualmente", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @CircuitBreaker(name = "catalogService")
    @GetMapping("/catalog")
    public ResponseEntity<String> catalogsFallback() {
        return new ResponseEntity<>("Servidor de catalogos no está disponible actualmente", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @CircuitBreaker(name = "serieService")
    @GetMapping("/serie")
    public ResponseEntity<String> seriesFallback() {
        return new ResponseEntity<>("Servidor de series no está disponible actualmente", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
