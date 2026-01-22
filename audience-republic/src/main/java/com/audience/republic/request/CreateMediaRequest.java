package com.audience.republic.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class CreateMediaRequest implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("media-type")
    @Expose
    @Builder.Default
    private String mediaType = "image";
    @SerializedName("media-path")
    @Expose
    @Builder.Default
    private String mediaPath = "https://www.eventliveus.com/long-logo.png";
    @Serial
    private final static long serialVersionUID = 6611114770189833576L;
}
