package com.hotel.ExceptionHandler;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }
}
