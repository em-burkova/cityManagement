package com.burkova.cityManagement.exceptions;

public class NameContainsNumbersException extends RuntimeException{

    public NameContainsNumbersException(String message){
        super(message);
    }
}
