package com.audience.republic.enums;

public enum GenderTypes {

    MALE("Male"),FEMALE("Female"),OTHER("Other"),;

    private final String gender;

    GenderTypes(String version){
        this.gender = version;
    }

    public String getValue(){
        return this.gender;
    }

}
