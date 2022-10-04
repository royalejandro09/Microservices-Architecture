package com.ramv.movieservice.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    /**
     * ModelMapper
     * Constructor of Class.
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
