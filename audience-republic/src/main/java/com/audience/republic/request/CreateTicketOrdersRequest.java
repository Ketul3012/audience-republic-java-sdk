package com.audience.republic.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTicketOrdersRequest implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("purchase-date")
    @Expose
    private DateTime purchaseDate;
    @SerializedName("purchaser")
    @Expose
    private CreateContactsRequest purchaser;
    @SerializedName("purchaser-id")
    @Expose
    private Object purchaserId;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("fees")
    @Expose
    private Integer fees;
    @SerializedName("taxes")
    @Expose
    private Integer taxes;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("event-id")
    @Expose
    private String eventId;
    @SerializedName("tickets-ordered")
    @Expose
    private Integer ticketsOrdered;
    @SerializedName("ticket-class-id")
    @Expose
    private String ticketClassId;
    @Serial
    private final static long serialVersionUID = -7409045530739674678L;
}
