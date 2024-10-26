package com.aston.tour_service.exception;

public class LocalityNotFoundException extends RuntimeException {
    public LocalityNotFoundException(Long id) {
        super("Locality with id " + id + " not found");
    }
}
