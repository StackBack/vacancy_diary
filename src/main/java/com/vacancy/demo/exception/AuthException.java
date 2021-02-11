package com.vacancy.demo.exception;

public class AuthException extends RuntimeException{
    public AuthException() {
        super();
    }

    public AuthException(String message) {
        super(message);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
