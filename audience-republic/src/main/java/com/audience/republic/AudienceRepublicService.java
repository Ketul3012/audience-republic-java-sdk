package com.audience.republic;

import java.io.IOException;
import java.util.List;

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

public interface AudienceRepublicService {

    StatusResponse status() throws IOException;

    SuccessResponse createContacts(List<CreateContactsRequest> createContactsRequests) throws IOException;

    CreateMailingListResponse createMailingList(CreateMailingListRequest createMailingListRequest)
            throws IOException;

    SuccessResponse createEvents(List<CreateEventsRequest> requests) throws IOException;

    SuccessResponse createEventsOrders(List<CreateEventOrdersRequest> requests) throws IOException;

    SuccessResponse createTicketClasses(List<CreateTicketsClassRequest> requests) throws IOException;

    SuccessResponse createTicketOrders(List<CreateTicketOrdersRequest> requests) throws IOException;

    SuccessResponse createTickets(List<CreateTicketsRequest> requests) throws IOException;

}
