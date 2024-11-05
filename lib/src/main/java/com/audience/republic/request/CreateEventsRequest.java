package com.audience.republic.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CreateEventsRequest implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("start-date")
    @Expose
    private DateTime startDate;
    @SerializedName("end-date")
    @Expose
    private DateTime endDate;
    @SerializedName("venue")
    @Expose
    private CreateVenueRequest venue;
    @SerializedName("tour")
    @Expose
    private CreateTourRequest tour;
    @SerializedName("media")
    @Expose
    private List<CreateMediaRequest> media;
    @SerializedName("ticket-classes")
    @Expose
    private List<CreateTicketsClassRequest> ticketClasses;
    @SerializedName("orders")
    @Expose
    private List<CreateEventOrdersRequest> orders;
    @Serial
    private final static long serialVersionUID = -7432644313956622761L;

}
