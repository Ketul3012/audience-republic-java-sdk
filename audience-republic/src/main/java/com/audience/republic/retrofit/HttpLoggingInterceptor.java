package com.audience.republic.retrofit;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.audience.republic.enums.LogLevel;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * HTTP logging interceptor for logging API requests and responses.
 * Supports different log levels: DEBUG, INFO, and ERROR.
 * Uses java.util.logging which is built into Java - no external dependencies
 * required.
 */
public class HttpLoggingInterceptor implements Interceptor {

    private static final Logger logger = Logger.getLogger(HttpLoggingInterceptor.class.getName());
    private static final Charset UTF8 = StandardCharsets.UTF_8;

    private final LogLevel logLevel;
    private final boolean loggingEnabled;

    public HttpLoggingInterceptor(boolean loggingEnabled, LogLevel logLevel) {
        this.loggingEnabled = loggingEnabled;
        this.logLevel = logLevel;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!loggingEnabled) {
            return chain.proceed(chain.request());
        }

        Request request = chain.request();
        long startTime = System.nanoTime();

        // Log request based on log level
        if (logLevel == LogLevel.DEBUG || logLevel == LogLevel.INFO) {
            request = logRequest(request);
        }

        Response response;
        try {
            response = chain.proceed(request);
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

            // Log response based on log level
            if (logLevel == LogLevel.DEBUG || logLevel == LogLevel.INFO) {
                logResponse(response, elapsedTime);
            }

            return response;
        } catch (IOException e) {
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            logError(request, e, elapsedTime);
            throw e;
        }
    }

    private Request logRequest(Request request) {
        if (logLevel == LogLevel.DEBUG) {
            logger.log(Level.FINE, "--> {0} {1}", new Object[] { request.method(), request.url() });
            logger.log(Level.FINE, "Headers: {0}", request.headers());

            RequestBody requestBody = request.body();
            if (requestBody != null) {
                try {
                    Buffer buffer = new Buffer();
                    requestBody.writeTo(buffer);
                    Charset charset = UTF8;
                    MediaType contentType = requestBody.contentType();
                    if (contentType != null) {
                        charset = contentType.charset(UTF8);
                    }
                    String bodyString = buffer.readString(charset);
                    logger.log(Level.FINE, "Request Body: {0}", bodyString);
                    // Create a new request body from the buffer since we consumed it
                    request = request.newBuilder()
                            .method(request.method(), RequestBody.create(contentType, buffer.readByteArray()))
                            .build();
                } catch (IOException e) {
                    logger.log(Level.FINE, "Request Body: <unable to read>");
                }
            }
            logger.log(Level.FINE, "--> END {0}", request.method());
        } else if (logLevel == LogLevel.INFO) {
            logger.log(Level.INFO, "--> {0} {1}", new Object[] { request.method(), request.url() });
        }
        return request;
    }

    private void logResponse(Response response, long elapsedTime) {
        if (logLevel == LogLevel.DEBUG) {
            logger.log(Level.FINE, "<-- {0} {1} ({2}ms)",
                    new Object[] { response.code(), response.message(), elapsedTime });
            logger.log(Level.FINE, "Response Headers: {0}", response.headers());

            try {
                ResponseBody responseBody = response.peekBody(Long.MAX_VALUE);
                if (responseBody != null) {
                    try {
                        String bodyString = responseBody.string();
                        logger.log(Level.FINE, "Response Body: {0}", bodyString);
                    } catch (IOException e) {
                        logger.log(Level.FINE, "Response Body: <unable to read>");
                    }
                }
            } catch (IOException e) {
                logger.log(Level.FINE, "Response Body: <unable to peek>");
            }
            logger.log(Level.FINE, "<-- END HTTP");
        } else if (logLevel == LogLevel.INFO) {
            logger.log(Level.INFO, "<-- {0} {1} ({2}ms)",
                    new Object[] { response.code(), response.message(), elapsedTime });
        }
    }

    private void logError(Request request, IOException e, long elapsedTime) {
        if (logLevel == LogLevel.DEBUG || logLevel == LogLevel.INFO || logLevel == LogLevel.ERROR) {
            logger.log(Level.SEVERE, "<-- HTTP FAILED: {0} {1} ({2}ms)",
                    new Object[] { request.method(), request.url(), elapsedTime });
            logger.log(Level.SEVERE, "Error: {0}", e.getMessage());
            logger.log(Level.SEVERE, "Stack trace: ", e);
        }
    }
}
