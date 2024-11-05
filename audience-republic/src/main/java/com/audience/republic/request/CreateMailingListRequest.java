package com.audience.republic.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CreateMailingListRequest implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contact-ids")
    @Expose
    private List<String> contactIds;
    @Serial
    private final static long serialVersionUID = -1861066867766644585L;

}
