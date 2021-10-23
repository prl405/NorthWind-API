package com.sparta.northwindrest.exceptionhandlers;

public class EntityNotFoundException extends Exception{

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
