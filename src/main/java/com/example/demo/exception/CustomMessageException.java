package com.example.demo.exception;

public class CustomMessageException extends Exception {

    private String error;

    public CustomMessageException(String error) {
        this.error = error;
    }

    public String getMessage() {
        return error;
    }
}