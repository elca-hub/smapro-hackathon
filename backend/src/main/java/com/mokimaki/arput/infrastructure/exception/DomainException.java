package com.mokimaki.arput.infrastructure.exception;

public class DomainException extends RuntimeException{
    public DomainException(String message) {
        super(message);
    }
}
