package com.audience.republic.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class CreateEventsRequest implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    @Builder.Default
    private String name = "DEFAULT";
    @SerializedName("description")
    @Expose
    @Builder.Default
    private String description= "DEFAULT";
    @SerializedName("start-date")
    @Expose
    @Builder.Default
    private DateTime startDate = DateTime.now();
    @SerializedName("end-date")
    @Expose
    @Builder.Default
    private DateTime endDate = DateTime.now();
    @SerializedName("venue")
    @Expose
    private CreateVenueRequest venue;
    @SerializedName("tour")
    @Expose
    private CreateTourRequest tour;
    @SerializedName("media")
    @Expose
    @Builder.Default
    private List<CreateMediaRequest> media = new ArrayList<>();
    @SerializedName("ticket-classes")
    @Expose
    @Builder.Default
    private List<CreateTicketsClassRequest> ticketClasses = new ArrayList<>();
    @SerializedName("orders")
    @Expose
    @Builder.Default
    private List<CreateEventOrdersRequest> orders = new ArrayList<>();
    @Serial
    private final static long serialVersionUID = -7432644313956622761L;

}
