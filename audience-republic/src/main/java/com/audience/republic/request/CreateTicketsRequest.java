package com.audience.republic.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTicketsRequest implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("ticket-class-id")
    @Expose
    private String ticketClassId;
    @SerializedName("order-id")
    @Expose
    private String orderId;
    @SerializedName("refunded")
    @Expose
    private Boolean refunded;
    @SerializedName("cancelled")
    @Expose
    private Boolean cancelled;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("fees")
    @Expose
    private Integer fees;
    @SerializedName("taxes")
    @Expose
    private Integer taxes;
    @SerializedName("attendee")
    @Expose
    private CreateContactsRequest attendee;
    @SerializedName("attendee-id")
    @Expose
    private String attendeeId;
    @Serial
    private final static long serialVersionUID = -7724889610539107374L;

}
