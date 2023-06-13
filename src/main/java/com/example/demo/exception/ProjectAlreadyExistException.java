package com.example.demo.exception;

public class ProjectAlreadyExistException extends Exception{
    public ProjectAlreadyExistException(String message, String title, String projectEntityTitle) {
        super(message);
    }
}
