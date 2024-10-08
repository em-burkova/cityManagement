package com.burkova.cityManagement.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
    }
    public EntityNotFoundException(String message) {
        super(message);
    }


}
