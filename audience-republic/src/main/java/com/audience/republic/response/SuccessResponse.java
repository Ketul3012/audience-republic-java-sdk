package com.audience.republic.response;


import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SuccessResponse {

    @SerializedName("success")
    private boolean success;

}
