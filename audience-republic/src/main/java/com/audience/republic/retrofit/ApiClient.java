package com.audience.republic.retrofit;

import com.audience.republic.retrofit.service.ApiService;
import com.audience.republic.enums.AudienceRepublicVersions;
import com.audience.republic.enums.LogLevel;
import com.google.gson.*;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.lang.reflect.Type;

public class ApiClient {

    public static ApiService getClient(AudienceRepublicVersions audienceRepublicVersions, String token) {
        return getClient(audienceRepublicVersions, token, false, LogLevel.INFO);
    }

    public static ApiService getClient(AudienceRepublicVersions audienceRepublicVersions, String token, boolean enableLogging, LogLevel logLevel) {
        // Interceptor to add the token to the header
        Interceptor tokenInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request requestWithToken = originalRequest.newBuilder()
                        .header("Authorization", "Bearer " + token)
                        .build();
                return chain.proceed(requestWithToken);
            }
        };

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .addInterceptor(tokenInterceptor);

        // Add logging interceptor if logging is enabled
        if (enableLogging) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(enableLogging, logLevel);
            clientBuilder.addInterceptor(loggingInterceptor);
        }

        OkHttpClient client = clientBuilder.build();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(DateTime.class, (JsonSerializer<DateTime>) (dateTime, typeOfSrc, context) -> new JsonPrimitive(ISODateTimeFormat.dateTime().print(dateTime)))
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(audienceRepublicVersions.getValue())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(ApiService.class);
    }

}
