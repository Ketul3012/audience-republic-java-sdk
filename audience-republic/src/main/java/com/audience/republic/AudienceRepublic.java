package com.audience.republic;

import com.audience.republic.enums.AudienceRepublicVersions;

public class AudienceRepublic {

    public static AudienceRepublicService getClient(AudienceRepublicVersions audienceRepublicVersions, String provider, String token){
        return new AudienceRepublicServiceImpl(provider,audienceRepublicVersions,token);
    }

}
