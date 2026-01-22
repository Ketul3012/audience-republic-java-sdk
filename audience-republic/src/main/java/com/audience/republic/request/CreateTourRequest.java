package com.audience.republic.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTourRequest implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    @Builder.Default
    private String name = "DEFAULT";
    @SerializedName("description")
    @Expose
    @Builder.Default
    private String description = "DEFAULT";
    @SerializedName("start-date")
    @Expose
    @Builder.Default
    private DateTime startDate = DateTime.now();
    @SerializedName("end-date")
    @Expose
    @Builder.Default
    private DateTime endDate = DateTime.now();
    @SerializedName("url")
    @Expose
    @Builder.Default
    private String url = "https://www.eventliveus.com";
    @Serial
    private final static long serialVersionUID = 6102102124819160968L;
}
