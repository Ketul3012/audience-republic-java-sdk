package com.audience.republic.request;

import com.audience.republic.enums.GenderTypes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CreateContactsRequest implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("first-name")
    @Expose
    @Builder.Default
    private String firstName = "DEFAULT";
    @SerializedName("last-name")
    @Expose
    @Builder.Default
    private String lastName = "DEFAULT";
    @SerializedName("gender")
    @Expose
    @Builder.Default
    private GenderTypes gender = GenderTypes.OTHER;
    @SerializedName("birth-date")
    @Expose
    @Builder.Default
    private DateTime birthDate = DateTime.now();
    @SerializedName("mobile-number")
    @Expose
    @Builder.Default
    private String mobileNumber= "DEFAULT";
    @SerializedName("email-address")
    @Expose
    @Builder.Default
    private String emailAddress= "DEFAULT";
    @SerializedName("marketing-opt-in")
    @Expose
    @Builder.Default
    private Boolean marketingOptIn = Boolean.TRUE;
    @SerializedName("street-address")
    @Expose
    @Builder.Default
    private String streetAddress= "DEFAULT";
    @SerializedName("suburb")
    @Expose
    @Builder.Default
    private String suburb= "DEFAULT";
    @SerializedName("postcode")
    @Expose
    @Builder.Default
    private String postcode= "DEFAULT";
    @SerializedName("city")
    @Expose
    @Builder.Default
    private String city= "DEFAULT";
    @SerializedName("state")
    @Expose
    @Builder.Default
    private String state= "DEFAULT";
    @SerializedName("country")
    @Expose
    @Builder.Default
    private String country= "US";
    @SerializedName("tags")
    @Expose
    @Builder.Default
    private List<String> tags = new ArrayList<>();
    @Serial
    private final static long serialVersionUID = 6294356973643074561L;
}
