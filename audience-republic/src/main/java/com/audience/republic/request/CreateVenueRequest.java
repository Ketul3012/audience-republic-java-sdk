package com.audience.republic.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class CreateVenueRequest implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    @Builder.Default
    private String name = "DEFAULT";
    @SerializedName("address")
    @Expose
    @Builder.Default
    private String address = "DEFAULT";
    @SerializedName("city")
    @Expose
    @Builder.Default
    private String city = "DEFAULT";
    @SerializedName("state")
    @Expose
    @Builder.Default
    private String state = "DEFAULT";
    @SerializedName("country")
    @Expose
    @Builder.Default
    private String country = "US";
    @SerializedName("timezone")
    @Expose
    @Builder.Default
    private String timezone = "DEFAULT";
    @SerializedName("capacity")
    @Expose
    @Builder.Default
    private Integer capacity = Integer.MAX_VALUE;
    @Serial
    private final static long serialVersionUID = -2012114409384372377L;
}
