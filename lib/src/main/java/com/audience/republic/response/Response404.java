package com.audience.republic.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Response404 implements Serializable {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("hint")
    @Expose
    private String hint;
    @Serial
    private final static long serialVersionUID = 2158468032625112797L;

}
