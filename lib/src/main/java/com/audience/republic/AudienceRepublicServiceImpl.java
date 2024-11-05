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

    public AudienceRepublicServiceImpl(AudienceRepublicVersions audienceRepublicVersions, String token){
        apiService = ApiClient.getClient(audienceRepublicVersions,token);
    }

    @Override
    public StatusResponse status(String provider) throws IOException {
        return apiService.status(provider).execute().body();
    }

    @Override
    public SuccessResponse createContacts(String provider, List<CreateContactsRequest> createContactsRequests) throws IOException {
        return apiService.createContacts(provider, createContactsRequests).execute().body();
    }

    @Override
    public CreateMailingListResponse createMailingList(String provider, CreateMailingListRequest createMailingListRequest) throws IOException {
        return apiService.createMailingList(provider, createMailingListRequest).execute().body();
    }

    @Override
    public SuccessResponse createEvents(String provider, List<CreateEventsRequest> requests) throws IOException {
        return apiService.createEvents(provider, requests).execute().body();
    }

    @Override
    public SuccessResponse createEventsOrders(String provider, List<CreateEventOrdersRequest> requests) throws IOException {
        return apiService.createEventsOrders(provider, requests).execute().body();
    }

    @Override
    public SuccessResponse createTicketClasses(String provider, List<CreateTicketsClassRequest> requests) throws IOException {
        return apiService.createTicketClasses(provider, requests).execute().body();
    }

    @Override
    public SuccessResponse createTicketOrders(String provider, List<CreateTicketOrdersRequest> requests) throws IOException {
        return apiService.createTicketOrders(provider, requests).execute().body();
    }

    @Override
    public SuccessResponse createTickets(String provider, List<CreateTicketsRequest> requests) throws IOException {
        return apiService.createTickets(provider, requests).execute().body();
    }
}
