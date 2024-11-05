package com.audience.republic.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CreateMailingListResponse implements Serializable {

    @SerializedName("mailing-list-name")
    @Expose
    private String mailingListName;
    @SerializedName("contacts-added")
    @Expose
    private Integer contactsAdded;
    @Serial
    private final static long serialVersionUID = 1374421331637138726L;
}
