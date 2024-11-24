package com.burkova.carinsurance.exceptions;

public class CarNotFoundedException extends RuntimeException{

    public CarNotFoundedException(){}

    public CarNotFoundedException(String message){
        super(message);
    }
}
