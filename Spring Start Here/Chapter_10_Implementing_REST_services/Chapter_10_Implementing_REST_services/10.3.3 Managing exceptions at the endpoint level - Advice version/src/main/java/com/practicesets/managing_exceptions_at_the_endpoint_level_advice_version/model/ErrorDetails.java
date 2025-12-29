package com.practicesets.managing_exceptions_at_the_endpoint_level_advice_version.model;

public class ErrorDetails {
    private String message;

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}