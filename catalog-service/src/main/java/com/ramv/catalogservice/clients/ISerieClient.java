package com.ramv.catalogservice.clients;

import com.ramv.catalogservice.dtos.SerieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "serie-service")
public interface ISerieClient {

    @GetMapping("/serie/{genre}")
    List<SerieDTO> getSerieByGenre(@PathVariable String genre);
}
