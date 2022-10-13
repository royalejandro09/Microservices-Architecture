package com.ramv.catalogservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationHandlerException extends ResponseEntityExceptionHandler {

    /**
     * CatalogNotFoundException.class
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CatalogNotFoundException.class)
    public ResponseEntity<?> catalogoNoEncontrado(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

}
