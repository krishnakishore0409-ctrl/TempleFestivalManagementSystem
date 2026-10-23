 package com.example.TempleFestival.exception;

import java.time.LocalDateTime;

import java.util.Map;
public class ErrorResponse {
    

    private int status;
    private String message;
    private LocalDateTime timestamp;
    private String path;
    private Map<String , String> errors;

    public ErrorResponse(int status,String message,LocalDateTime timestamp,String path){
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.path = path;
    }


    public ErrorResponse(int status,String message,LocalDateTime timestamp,String path,Map<String , String> errors){
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.path = path;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }

    public Map<String , String> getErrors(){
        return errors;
    }
}
