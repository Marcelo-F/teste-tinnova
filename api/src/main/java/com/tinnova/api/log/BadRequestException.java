package com.tinnova.api.log;

public class BadRequestException extends RuntimeException{


    public BadRequestException(String message) {
        super(message);
    }
}
