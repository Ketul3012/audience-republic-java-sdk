package com.audience.republic.exception;

import java.io.Serial;

/**
 * Exception thrown when an API call fails with an error response.
 * Contains the HTTP status code and the error response body.
 */
public class ApiException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    private final int statusCode;
    private final Object errorResponse;

    public ApiException(int statusCode, Object errorResponse, String message) {
        super(message);
        this.statusCode = statusCode;
        this.errorResponse = errorResponse;
    }

    public ApiException(int statusCode, Object errorResponse) {
        super("API call failed with status code: " + statusCode);
        this.statusCode = statusCode;
        this.errorResponse = errorResponse;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Object getErrorResponse() {
        return errorResponse;
    }

}
