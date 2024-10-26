package com.aston.tour_service.exception;

public class AttractionNotFoundException extends RuntimeException {
    public AttractionNotFoundException(Long id) {
        super("Attraction with id " + id + " not found");
    }
}
