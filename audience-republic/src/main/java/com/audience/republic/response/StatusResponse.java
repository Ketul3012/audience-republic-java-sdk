package com.audience.republic.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class StatusResponse implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;

}
