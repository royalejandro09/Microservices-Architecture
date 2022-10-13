package com.ramv.catalogservice.exceptions;

public class CatalogNotFoundException extends Exception {

    public CatalogNotFoundException(String mensaje) {
        super(mensaje);
    }
}
