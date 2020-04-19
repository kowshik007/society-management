package com.application.start.entity;

import java.time.OffsetDateTime;

public class ErrorResponseHandler {
    private int status;
    private String message;
    private OffsetDateTime timeStamp;

    public ErrorResponseHandler() {
    }

    public ErrorResponseHandler(int status, String message, OffsetDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OffsetDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(OffsetDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
