package com.ramv.catalogservice.controllers;

import com.ramv.catalogservice.entities.Catalog;
import com.ramv.catalogservice.exceptions.CatalogNotFoundException;
import com.ramv.catalogservice.service.ICatalogService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final ICatalogService catalogService;

    @Autowired
    public CatalogController(ICatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping()
    public ResponseEntity<List<Catalog>> gatAllCatalogs(){
        List<Catalog> catalogResponse = catalogService.fidAllCatalogs();
        return new ResponseEntity<>(catalogResponse, HttpStatus.OK);
    }

    @GetMapping("/{genre}")
    public ResponseEntity<Catalog> getCatalogByGenre(@PathVariable String genre) throws CatalogNotFoundException {
        Catalog catalogResponse = catalogService.findCatalogByGenre(genre);
        return new ResponseEntity<>(catalogResponse, HttpStatus.OK);
    }
}
