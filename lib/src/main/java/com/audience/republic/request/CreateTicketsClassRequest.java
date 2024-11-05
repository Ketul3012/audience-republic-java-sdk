package com.audience.republic.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class CreateTicketsClassRequest implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("event-id")
    @Expose
    private String eventId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
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
    @Serial
    private final static long serialVersionUID = -8966535931358601030L;
}
