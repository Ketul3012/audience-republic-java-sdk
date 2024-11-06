package com.audience.republic;

import com.audience.republic.request.*;
import com.audience.republic.response.CreateMailingListResponse;
import com.audience.republic.response.StatusResponse;
import com.audience.republic.response.SuccessResponse;
import com.audience.republic.retrofit.ApiClient;
import com.audience.republic.retrofit.service.ApiService;
import com.audience.republic.enums.AudienceRepublicVersions;

import java.io.IOException;
import java.util.List;

class AudienceRepublicServiceImpl implements AudienceRepublicService {

    private final ApiService apiService;

    private final String DEFAULT_PROVIDER;
    public AudienceRepublicServiceImpl(String provider, AudienceRepublicVersions audienceRepublicVersions, String token){
        apiService = ApiClient.getClient(audienceRepublicVersions,token);
        DEFAULT_PROVIDER=provider;
    }

    @Override
    public StatusResponse status() throws IOException {
        return apiService.status(DEFAULT_PROVIDER).execute().body();
    }

    @Override
    public SuccessResponse createContacts(List<CreateContactsRequest> createContactsRequests) throws IOException {
        return apiService.createContacts(DEFAULT_PROVIDER, createContactsRequests).execute().body();
    }

    @Override
    public CreateMailingListResponse createMailingList(CreateMailingListRequest createMailingListRequest) throws IOException {
        return apiService.createMailingList(DEFAULT_PROVIDER, createMailingListRequest).execute().body();
    }

    @Override
    public SuccessResponse createEvents(List<CreateEventsRequest> requests) throws IOException {
        return apiService.createEvents(DEFAULT_PROVIDER, requests).execute().body();
    }

    @Override
    public SuccessResponse createEventsOrders(List<CreateEventOrdersRequest> requests) throws IOException {
        return apiService.createEventsOrders(DEFAULT_PROVIDER, requests).execute().body();
    }

    @Override
    public SuccessResponse createTicketClasses(List<CreateTicketsClassRequest> requests) throws IOException {
        return apiService.createTicketClasses(DEFAULT_PROVIDER, requests).execute().body();
    }

    @Override
    public SuccessResponse createTicketOrders(List<CreateTicketOrdersRequest> requests) throws IOException {
        return apiService.createTicketOrders(DEFAULT_PROVIDER, requests).execute().body();
    }

    @Override
    public SuccessResponse createTickets(List<CreateTicketsRequest> requests) throws IOException {
        return apiService.createTickets(DEFAULT_PROVIDER, requests).execute().body();
    }
}
