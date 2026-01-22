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
import com.audience.republic.response.StatusResponse;
import com.audience.republic.response.SuccessResponse;
import com.audience.republic.retrofit.ApiClient;
import com.audience.republic.retrofit.service.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
            StatusResponse response = apiService.status(DEFAULT_PROVIDER).execute().body();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceResponse(methodName, response, elapsedTime);
            return response;
        } catch (IOException e) {
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceError(methodName, e, elapsedTime);
            throw e;
        }
    }

    @Override
    public SuccessResponse createContacts(List<CreateContactsRequest> createContactsRequests) throws IOException {
        String methodName = "createContacts";
        long startTime = System.nanoTime();

        logServiceRequest(methodName, "createContactsRequests", createContactsRequests);

        try {
            SuccessResponse response = apiService.createContacts(DEFAULT_PROVIDER, createContactsRequests).execute()
                    .body();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceResponse(methodName, response, elapsedTime);
            return response;
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
            CreateMailingListResponse response = apiService
                    .createMailingList(DEFAULT_PROVIDER, createMailingListRequest).execute().body();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceResponse(methodName, response, elapsedTime);
            return response;
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
            SuccessResponse response = apiService.createEvents(DEFAULT_PROVIDER, requests).execute().body();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceResponse(methodName, response, elapsedTime);
            return response;
        } catch (IOException e) {
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceError(methodName, e, elapsedTime);
            throw e;
        }
    }

    @Override
    public SuccessResponse createEventsOrders(List<CreateEventOrdersRequest> requests) throws IOException {
        String methodName = "createEventsOrders";
        long startTime = System.nanoTime();

        logServiceRequest(methodName, "requests", requests);

        try {
            SuccessResponse response = apiService.createEventsOrders(DEFAULT_PROVIDER, requests).execute().body();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceResponse(methodName, response, elapsedTime);
            return response;
        } catch (IOException e) {
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceError(methodName, e, elapsedTime);
            throw e;
        }
    }

    @Override
    public SuccessResponse createTicketClasses(List<CreateTicketsClassRequest> requests) throws IOException {
        String methodName = "createTicketClasses";
        long startTime = System.nanoTime();

        logServiceRequest(methodName, "requests", requests);

        try {
            SuccessResponse response = apiService.createTicketClasses(DEFAULT_PROVIDER, requests).execute().body();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceResponse(methodName, response, elapsedTime);
            return response;
        } catch (IOException e) {
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceError(methodName, e, elapsedTime);
            throw e;
        }
    }

    @Override
    public SuccessResponse createTicketOrders(List<CreateTicketOrdersRequest> requests) throws IOException {
        String methodName = "createTicketOrders";
        long startTime = System.nanoTime();

        logServiceRequest(methodName, "requests", requests);

        try {
            SuccessResponse response = apiService.createTicketOrders(DEFAULT_PROVIDER, requests).execute().body();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceResponse(methodName, response, elapsedTime);
            return response;
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
            SuccessResponse response = apiService.createTickets(DEFAULT_PROVIDER, requests).execute().body();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceResponse(methodName, response, elapsedTime);
            return response;
        } catch (IOException e) {
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logServiceError(methodName, e, elapsedTime);
            throw e;
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
            logMessage.append("[SERVICE] Calling method: ").append(methodName);
            logMessage.append(" | Provider: ").append(DEFAULT_PROVIDER);

            if (requestData != null && paramName != null) {
                try {
                    String jsonData = gson.toJson(requestData);
                    logMessage.append(" | ").append(paramName).append(": ").append(jsonData);
                } catch (Exception e) {
                    logMessage.append(" | ").append(paramName).append(": <unable to serialize>");
                }
            }

            logger.log(Level.FINE, logMessage.toString());
        } else if (logLevel == LogLevel.INFO) {
            logger.log(Level.INFO, "[SERVICE] Calling method: {0} | Provider: {1}",
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
            logMessage.append("[SERVICE] Method: ").append(methodName);
            logMessage.append(" | Completed in: ").append(elapsedTime).append("ms");

            if (response != null) {
                try {
                    String jsonResponse = gson.toJson(response);
                    logMessage.append(" | Response: ").append(jsonResponse);
                } catch (Exception e) {
                    logMessage.append(" | Response: <unable to serialize>");
                }
            } else {
                logMessage.append(" | Response: null");
            }

            logger.log(Level.FINE, logMessage.toString());
        } else if (logLevel == LogLevel.INFO) {
            logger.log(Level.INFO, "[SERVICE] Method: {0} | Completed in: {1}ms",
                    new Object[] { methodName, elapsedTime });
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
