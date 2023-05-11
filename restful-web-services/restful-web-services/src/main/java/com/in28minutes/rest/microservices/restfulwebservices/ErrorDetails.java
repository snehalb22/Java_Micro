package com.in28minutes.rest.microservices.restfulwebservices;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {

    private String message;


    private LocalDateTime timeStamp;

    private String details;
    public ErrorDetails(String message, LocalDateTime timeStamp, String details) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getDetails() {
        return details;
    }



}
