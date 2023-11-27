package com.mokimaki.arput.infrastructure.exception;

public class UseCaseException extends RuntimeException{
    public UseCaseException(String message) {
        super(message);
    }
}
