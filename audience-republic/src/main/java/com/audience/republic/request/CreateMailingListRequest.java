package com.audience.republic.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMailingListRequest implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contact-ids")
    @Expose
    @Builder.Default
    private List<String> contactIds = new ArrayList<>();
    @Serial
    private final static long serialVersionUID = -1861066867766644585L;

}
