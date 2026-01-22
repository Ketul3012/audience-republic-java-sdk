package com.audience.republic.enums;

/**
 * Enum representing different log levels for API request/response logging.
 */
public enum LogLevel {
    /**
     * DEBUG level - logs all request/response details including headers and body
     */
    DEBUG,
    
    /**
     * INFO level - logs request method, URL, response code, and timing
     */
    INFO,
    
    /**
     * ERROR level - logs only errors and failed requests
     */
    ERROR
}
