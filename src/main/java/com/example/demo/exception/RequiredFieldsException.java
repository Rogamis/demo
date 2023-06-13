package com.example.demo.exception;

public class RequiredFieldsException extends Exception{

    private String error;

    public RequiredFieldsException(String[] fields) {
        StringBuilder error = new StringBuilder();
        error.append("Fields: ");
        for(int i = 0; i < fields.length; i++){
            error.append("[" + fields[i] + "] ");
        }
        error.append("are required.");
        this.error = error.toString();
    }

    public String getMessage(){
        return this.error;
    }
}