package com.audience.republic;

import com.audience.republic.request.*;
import com.audience.republic.response.CreateMailingListResponse;
import com.audience.republic.response.StatusResponse;
import com.audience.republic.response.SuccessResponse;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.io.IOException;
import java.util.List;

public interface AudienceRepublicService {

    StatusResponse status(String provider) throws IOException;

    SuccessResponse createContacts(String provider,List<CreateContactsRequest> createContactsRequests) throws IOException;

    CreateMailingListResponse createMailingList(String provider, CreateMailingListRequest createMailingListRequest) throws IOException;

    SuccessResponse createEvents(String provider, List<CreateEventsRequest> requests) throws IOException;

    SuccessResponse createEventsOrders(String provider, List<CreateEventOrdersRequest> requests) throws IOException;

    SuccessResponse createTicketClasses(String provider, List<CreateTicketsClassRequest> requests) throws IOException;

    SuccessResponse createTicketOrders(String provider, List<CreateTicketOrdersRequest> requests) throws IOException;

    SuccessResponse createTickets(String provider, List<CreateTicketsRequest> requests) throws IOException;

}
