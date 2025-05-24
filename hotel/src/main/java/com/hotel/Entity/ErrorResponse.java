package com.hotel.Entity;

import java.time.LocalDate;

public class ErrorResponse {
    private LocalDate timeStamp;
    private String message;
    private int status;

    public ErrorResponse(LocalDate timeStamp, String message, int status) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.status = status;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

