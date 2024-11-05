package com.audience.republic.retrofit.service;

import com.audience.republic.request.*;
import com.audience.republic.response.CreateMailingListResponse;
import com.audience.republic.response.StatusResponse;
import com.audience.republic.response.SuccessResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface ApiService {

    @GET("status")
    Call<StatusResponse> status(@Query("provider") String provider);

    @POST("contacts")
    Call<SuccessResponse> createContacts(@Query("provider") String provider, @Body List<CreateContactsRequest> requests);

    @POST("mailing-list")
    Call<CreateMailingListResponse> createMailingList(@Query("provider") String provider, @Body CreateMailingListRequest createMailingListRequest);

    @POST("events")
    Call<SuccessResponse> createEvents(@Query("provider") String provider, @Body List<CreateEventsRequest> requests);

    @POST("event-orders")
    Call<SuccessResponse> createEventsOrders(@Query("provider") String provider, @Body List<CreateEventOrdersRequest> requests);

    @POST("ticket-classes")
    Call<SuccessResponse> createTicketClasses(@Query("provider") String provider, @Body List<CreateTicketsClassRequest> requests);

    @POST("ticket-orders")
    Call<SuccessResponse> createTicketOrders(@Query("provider") String provider, @Body List<CreateTicketOrdersRequest> requests);

    @POST("tickets")
    Call<SuccessResponse> createTickets(@Query("provider") String provider, @Body List<CreateTicketsRequest> requests);

}
