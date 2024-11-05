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
    private String firstName;
    @SerializedName("last-name")
    @Expose
    private String lastName;
    @SerializedName("gender")
    @Expose
    private GenderTypes gender;
    @SerializedName("birth-date")
    @Expose
    private DateTime birthDate;
    @SerializedName("mobile-number")
    @Expose
    private String mobileNumber;
    @SerializedName("email-address")
    @Expose
    private String emailAddress;
    @SerializedName("marketing-opt-in")
    @Expose
    private Boolean marketingOptIn;
    @SerializedName("street-address")
    @Expose
    private String streetAddress;
    @SerializedName("suburb")
    @Expose
    private String suburb;
    @SerializedName("postcode")
    @Expose
    private String postcode;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("tags")
    @Expose
    private List<String> tags;
    @Serial
    private final static long serialVersionUID = 6294356973643074561L;
}
