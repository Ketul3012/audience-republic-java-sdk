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

    StatusResponse status() throws IOException;

    SuccessResponse createContacts(List<CreateContactsRequest> createContactsRequests) throws IOException;

    CreateMailingListResponse createMailingList(CreateMailingListRequest createMailingListRequest) throws IOException;

    SuccessResponse createEvents(List<CreateEventsRequest> requests) throws IOException;

    SuccessResponse createEventsOrders(List<CreateEventOrdersRequest> requests) throws IOException;

    SuccessResponse createTicketClasses(List<CreateTicketsClassRequest> requests) throws IOException;

    SuccessResponse createTicketOrders(List<CreateTicketOrdersRequest> requests) throws IOException;

    SuccessResponse createTickets(List<CreateTicketsRequest> requests) throws IOException;

}
