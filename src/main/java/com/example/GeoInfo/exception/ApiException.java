package com.example.GeoInfo.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
    private int statusCode; // HTTP status code (optional)
    private String errorDetails; // Additional error information (optional)


    public ApiException(String message) {
        super(message);
    }

    public ApiException() {
        super("An error occurred -> Custom");
    }

    // Constructor with message and status code
    public ApiException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    // Constructor with message, status code, and detailed error info
    public ApiException(String message, int statusCode, String errorDetails) {
        super(message);
        this.statusCode = statusCode;
        this.errorDetails = errorDetails;
    }

}
