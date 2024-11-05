package com.audience.republic.enums;

public enum AudienceRepublicVersions {

    V1("https://arep.co/api/v1/ingest/");

    private final String version;

    AudienceRepublicVersions(String version){
        this.version = version;
    }

    public String getValue(){
        return this.version;
    }
}
