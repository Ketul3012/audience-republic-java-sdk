package com.audience.republic;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import com.audience.republic.enums.AudienceRepublicVersions;
import com.audience.republic.enums.LogLevel;
import com.audience.republic.request.CreateContactsRequest;
import com.audience.republic.request.CreateEventOrdersRequest;
import com.audience.republic.request.CreateEventsRequest;
import com.audience.republic.request.CreateMailingListRequest;
import com.audience.republic.request.CreateTicketOrdersRequest;
import com.audience.republic.request.CreateTicketsClassRequest;
import com.audience.republic.request.CreateTicketsRequest;
import com.audience.republic.response.CreateMailingListResponse;
import com.audience.republic.response.Response401;
import com.audience.republic.response.Response403;
import com.audience.republic.response.Response404;
import com.audience.republic.response.Response422;
import com.audience.republic.response.Response500;
import com.audience.republic.response.Response503;
import com.audience.republic.response.StatusResponse;
import com.audience.republic.response.SuccessResponse;
import com.audience.republic.retrofit.ApiClient;
import com.audience.republic.retrofit.service.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import retrofit2.Response;

class AudienceRepublicServiceImpl implements AudienceRepublicService {

    private static final Logger logger = Logger.getLogger(AudienceRepublicServiceImpl.class.getName());
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(DateTime.class,
                    (com.google.gson.JsonSerializer<DateTime>) (dateTime, typeOfSrc,
                            context) -> new com.google.gson.JsonPrimitive(ISODateTimeFormat.dateTime().print(dateTime)))
            .setPrettyPrinting()
            .create();

    private final ApiService apiService;
    private final String DEFAULT_PROVIDER;
    private final boolean loggingEnabled;
    private final LogLevel logLevel;

    public AudienceRepublicServiceImpl(String provider, AudienceRepublicVersions audienceRepublicVersions,
            String token) {
        this(provider, audienceRepublicVersions, token, false, LogLevel.INFO);
    }

    public AudienceRepublicServiceImpl(String provider, AudienceRepublicVersions audienceRepublicVersions, String token,
            boolean enableLogging, LogLevel logLevel) {
        apiService = ApiClient.getClient(audienceRepublicVersions, token, enableLogging, logLevel);
        DEFAULT_PROVIDER = provider;
        this.loggingEnabled = enableLogging;
        this.logLevel = logLevel;
    }

    @Override
    public StatusResponse status() throws IOException {
        String methodName = "status";
        long startTime = System.nanoTime();

        logServiceRequest(methodName, null, null);

        try {
            Response<StatusResponse> response = apiService.status(DEFAULT_PROVIDER).execute();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

            if (!response.isSuccessful()) {
                Object errorResponse = parseErrorResponse(response);
                logServiceErrorResponse(methodName, response.code(), errorResponse, elapsedTime);
                return null;
            }

            StatusResponse body = response.body();
            logServiceResponse(methodName, body, elapsedTime);
            return body;
        } catch (IOException e) {
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceError(methodName, e, elapsedTime);
            throw e;
        }
    }

    @Override
    public SuccessResponse createContacts(List<CreateContactsRequest> createContactsRequests)
            throws IOException {
        String methodName = "createContacts";
        long startTime = System.nanoTime();

        logServiceRequest(methodName, "createContactsRequests", createContactsRequests);

        try {
            Response<SuccessResponse> response = apiService.createContacts(DEFAULT_PROVIDER, createContactsRequests)
                    .execute();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

            if (!response.isSuccessful()) {
                Object errorResponse = parseErrorResponse(response);
                logServiceErrorResponse(methodName, response.code(), errorResponse, elapsedTime);
                return null;
            }

            SuccessResponse body = response.body();
            logServiceResponse(methodName, body, elapsedTime);
            return body;
        } catch (IOException e) {
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceError(methodName, e, elapsedTime);
            throw e;
        }
    }

    @Override
    public CreateMailingListResponse createMailingList(CreateMailingListRequest createMailingListRequest)
            throws IOException {
        String methodName = "createMailingList";
        long startTime = System.nanoTime();

        logServiceRequest(methodName, "createMailingListRequest", createMailingListRequest);

        try {
            Response<CreateMailingListResponse> response = apiService
                    .createMailingList(DEFAULT_PROVIDER, createMailingListRequest).execute();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

            if (!response.isSuccessful()) {
                Object errorResponse = parseErrorResponse(response);
                logServiceErrorResponse(methodName, response.code(), errorResponse, elapsedTime);
                return null;
            }

            CreateMailingListResponse body = response.body();
            logServiceResponse(methodName, body, elapsedTime);
            return body;
        } catch (IOException e) {
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceError(methodName, e, elapsedTime);
            throw e;
        }
    }

    @Override
    public SuccessResponse createEvents(List<CreateEventsRequest> requests) throws IOException {
        String methodName = "createEvents";
        long startTime = System.nanoTime();

        logServiceRequest(methodName, "requests", requests);

        try {
            Response<SuccessResponse> response = apiService.createEvents(DEFAULT_PROVIDER, requests).execute();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

            if (!response.isSuccessful()) {
                Object errorResponse = parseErrorResponse(response);
                logServiceErrorResponse(methodName, response.code(), errorResponse, elapsedTime);
                return null;
            }

            SuccessResponse body = response.body();
            logServiceResponse(methodName, body, elapsedTime);
            return body;
        } catch (IOException e) {
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceError(methodName, e, elapsedTime);
            throw e;
        }
    }

    @Override
    public SuccessResponse createEventsOrders(List<CreateEventOrdersRequest> requests)
            throws IOException {
        String methodName = "createEventsOrders";
        long startTime = System.nanoTime();

        logServiceRequest(methodName, "requests", requests);

        try {
            Response<SuccessResponse> response = apiService.createEventsOrders(DEFAULT_PROVIDER, requests).execute();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

            if (!response.isSuccessful()) {
                Object errorResponse = parseErrorResponse(response);
                logServiceErrorResponse(methodName, response.code(), errorResponse, elapsedTime);
                return null;
            }

            SuccessResponse body = response.body();
            logServiceResponse(methodName, body, elapsedTime);
            return body;
        } catch (IOException e) {
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceError(methodName, e, elapsedTime);
            throw e;
        }
    }

    @Override
    public SuccessResponse createTicketClasses(List<CreateTicketsClassRequest> requests)
            throws IOException {
        String methodName = "createTicketClasses";
        long startTime = System.nanoTime();

        logServiceRequest(methodName, "requests", requests);

        try {
            Response<SuccessResponse> response = apiService.createTicketClasses(DEFAULT_PROVIDER, requests).execute();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

            if (!response.isSuccessful()) {
                Object errorResponse = parseErrorResponse(response);
                logServiceErrorResponse(methodName, response.code(), errorResponse, elapsedTime);
                return null;
            }

            SuccessResponse body = response.body();
            logServiceResponse(methodName, body, elapsedTime);
            return body;
        } catch (IOException e) {
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceError(methodName, e, elapsedTime);
            throw e;
        }
    }

    @Override
    public SuccessResponse createTicketOrders(List<CreateTicketOrdersRequest> requests)
            throws IOException {
        String methodName = "createTicketOrders";
        long startTime = System.nanoTime();

        logServiceRequest(methodName, "requests", requests);

        try {
            Response<SuccessResponse> response = apiService.createTicketOrders(DEFAULT_PROVIDER, requests).execute();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

            if (!response.isSuccessful()) {
                Object errorResponse = parseErrorResponse(response);
                logServiceErrorResponse(methodName, response.code(), errorResponse, elapsedTime);
                return null;
            }

            SuccessResponse body = response.body();
            logServiceResponse(methodName, body, elapsedTime);
            return body;
        } catch (IOException e) {
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceError(methodName, e, elapsedTime);
            throw e;
        }
    }

    @Override
    public SuccessResponse createTickets(List<CreateTicketsRequest> requests) throws IOException {
        String methodName = "createTickets";
        long startTime = System.nanoTime();

        logServiceRequest(methodName, "requests", requests);

        try {
            Response<SuccessResponse> response = apiService.createTickets(DEFAULT_PROVIDER, requests).execute();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

            if (!response.isSuccessful()) {
                Object errorResponse = parseErrorResponse(response);
                logServiceErrorResponse(methodName, response.code(), errorResponse, elapsedTime);
                return null;
            }

            SuccessResponse body = response.body();
            logServiceResponse(methodName, body, elapsedTime);
            return body;
        } catch (IOException e) {
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceError(methodName, e, elapsedTime);
            throw e;
        }
    }

    /**
     * Parses error response based on HTTP status code.
     * Returns the parsed object if successful, or the raw error body string if
     * parsing fails.
     */
    private Object parseErrorResponse(Response<?> response) {
        if (response.errorBody() == null) {
            return null;
        }

        try {
            String errorBodyString = response.errorBody().string();
            int statusCode = response.code();

            switch (statusCode) {
                case 400:
                    // 400 returns plain text "Bad request."
                    return errorBodyString;
                case 401:
                    return parseJsonSafely(errorBodyString, Response401.class, statusCode);
                case 403:
                    return parseJsonSafely(errorBodyString, Response403.class, statusCode);
                case 404:
                    return parseJsonSafely(errorBodyString, Response404.class, statusCode);
                case 422:
                    return parseJsonSafely(errorBodyString, Response422.class, statusCode);
                case 500:
                    return parseJsonSafely(errorBodyString, Response500.class, statusCode);
                case 503:
                    return parseJsonSafely(errorBodyString, Response503.class, statusCode);
                default:
                    // For other status codes, return the raw error body string
                    return errorBodyString;
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Failed to read error response body: {0}", e.getMessage());
            return null;
        }
    }

    /**
     * Safely parses JSON string to the specified type.
     * If parsing fails, returns the raw string instead of throwing an exception.
     */
    private Object parseJsonSafely(String jsonString, Class<?> targetClass, int statusCode) {
        try {
            return gson.fromJson(jsonString, targetClass);
        } catch (JsonSyntaxException e) {
            logger.log(Level.WARNING,
                    "Failed to parse error response for status {0} as {1}. Using raw response body. Error: {2}",
                    new Object[] { statusCode, targetClass.getSimpleName(), e.getMessage() });
            return jsonString;
        } catch (Exception e) {
            logger.log(Level.WARNING,
                    "Unexpected error parsing error response for status {0} as {1}. Using raw response body. Error: {2}",
                    new Object[] { statusCode, targetClass.getSimpleName(), e.getMessage() });
            return jsonString;
        }
    }

    /**
     * Logs service-level request information.
     */
    private void logServiceRequest(String methodName, String paramName, Object requestData) {
        if (!loggingEnabled) {
            return;
        }

        if (logLevel == LogLevel.DEBUG) {
            StringBuilder logMessage = new StringBuilder();
            logMessage.append("[SERVICE REQUEST] Method: ").append(methodName);
            logMessage.append(" | Provider: ").append(DEFAULT_PROVIDER);

            if (requestData != null && paramName != null) {
                try {
                    String jsonData = gson.toJson(requestData);
                    logMessage.append("\nRequest Body (").append(paramName).append("):\n").append(jsonData);
                } catch (Exception e) {
                    logMessage.append(" | ").append(paramName).append(": <unable to serialize>");
                }
            }

            logger.log(Level.FINE, logMessage.toString());
        } else if (logLevel == LogLevel.INFO) {
            logger.log(Level.INFO, "[SERVICE REQUEST] Method: {0} | Provider: {1}",
                    new Object[] { methodName, DEFAULT_PROVIDER });
        }
    }

    /**
     * Logs service-level response information.
     */
    private void logServiceResponse(String methodName, Object response, long elapsedTime) {
        if (!loggingEnabled) {
            return;
        }

        if (logLevel == LogLevel.DEBUG) {
            StringBuilder logMessage = new StringBuilder();
            logMessage.append("[SERVICE RESPONSE] Method: ").append(methodName);
            logMessage.append(" | Status: SUCCESS");
            logMessage.append(" | Completed in: ").append(elapsedTime).append("ms");

            if (response != null) {
                try {
                    String jsonResponse = gson.toJson(response);
                    logMessage.append("\nResponse Body:\n").append(jsonResponse);
                } catch (Exception e) {
                    logMessage.append(" | Response: <unable to serialize>");
                }
            } else {
                logMessage.append(" | Response: null");
            }

            logger.log(Level.FINE, logMessage.toString());
        } else if (logLevel == LogLevel.INFO) {
            logger.log(Level.INFO, "[SERVICE RESPONSE] Method: {0} | Status: SUCCESS | Completed in: {1}ms",
                    new Object[] { methodName, elapsedTime });
        }
    }

    /**
     * Logs service-level error response information.
     */
    private void logServiceErrorResponse(String methodName, int statusCode, Object errorResponse, long elapsedTime) {
        if (!loggingEnabled) {
            return;
        }

        if (logLevel == LogLevel.DEBUG || logLevel == LogLevel.INFO || logLevel == LogLevel.ERROR) {
            StringBuilder logMessage = new StringBuilder();
            logMessage.append("[SERVICE ERROR RESPONSE] Method: ").append(methodName);
            logMessage.append(" | Status Code: ").append(statusCode);
            logMessage.append(" | Failed after: ").append(elapsedTime).append("ms");

            if (errorResponse != null) {
                // If errorResponse is already a String, use it directly
                if (errorResponse instanceof String) {
                    logMessage.append("\nError Response Body:\n").append(errorResponse);
                } else {
                    // Try to serialize the object to JSON
                    try {
                        String jsonError = gson.toJson(errorResponse);
                        logMessage.append("\nError Response Body:\n").append(jsonError);
                    } catch (Exception e) {
                        // If serialization fails, log the toString() representation
                        logMessage.append("\nError Response Body (raw):\n").append(errorResponse.toString());
                        logger.log(Level.WARNING, "Failed to serialize error response to JSON: {0}", e.getMessage());
                    }
                }
            } else {
                logMessage.append(" | Error Response: null");
            }

            logger.log(Level.SEVERE, logMessage.toString());
        }
    }

    /**
     * Logs service-level error information.
     */
    private void logServiceError(String methodName, IOException e, long elapsedTime) {
        if (!loggingEnabled) {
            return;
        }

        if (logLevel == LogLevel.DEBUG || logLevel == LogLevel.INFO || logLevel == LogLevel.ERROR) {
            logger.log(Level.SEVERE,
                    "[SERVICE] Method: {0} | Failed after: {1}ms | Error: {2}",
                    new Object[] { methodName, elapsedTime, e.getMessage() });
            logger.log(Level.SEVERE, "Stack trace: ", e);
        }
    }
}
