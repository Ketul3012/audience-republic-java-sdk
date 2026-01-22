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
public class CreateEventOrdersRequest implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("purchase-date")
    @Expose
    @Builder.Default
    private DateTime purchaseDate = DateTime.now();
    @SerializedName("purchaser")
    @Expose
    private CreateContactsRequest purchaser;
    @SerializedName("purchaser-id")
    @Expose
    private String purchaserId;
    @SerializedName("currency")
    @Expose
    @Builder.Default
    private String currency = "USD";
    @SerializedName("total")
    @Expose
    @Builder.Default
    private Integer total = 0;
    @SerializedName("fees")
    @Expose
    @Builder.Default
    private Integer fees = 0;
    @SerializedName("taxes")
    @Expose
    @Builder.Default
    private Integer taxes = 0;
    @SerializedName("status")
    @Expose
    @Builder.Default
    private String status = "completed";
    @SerializedName("event-id")
    @Expose
    private String eventId;
    @SerializedName("tickets")
    @Expose
    @Builder.Default
    private List<CreateTicketsRequest> tickets = new ArrayList<>();
    @Serial
    private final static long serialVersionUID = -7409045530739674678L;
}
