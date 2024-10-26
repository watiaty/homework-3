package com.aston.tour_service.exception;

public class LocalityAlreadyExistException extends RuntimeException {
    public LocalityAlreadyExistException(String name, String region) {
        super("Locality with name '" + name + "' and region '" + region + "' already exists");
    }
}
