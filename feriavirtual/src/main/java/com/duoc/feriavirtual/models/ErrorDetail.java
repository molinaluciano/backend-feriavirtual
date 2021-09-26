package com.duoc.feriavirtual.models;

public class ErrorDetail {
    public ErrorDetail(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
