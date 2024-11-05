package com.audience.republic.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class CreateTourRequest implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("start-date")
    @Expose
    private DateTime startDate;
    @SerializedName("end-date")
    @Expose
    private DateTime endDate;
    @SerializedName("url")
    @Expose
    private String url;
    @Serial
    private final static long serialVersionUID = 6102102124819160968L;

}
