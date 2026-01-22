package com.audience.republic;

import com.audience.republic.enums.AudienceRepublicVersions;
import com.audience.republic.enums.LogLevel;

public class AudienceRepublic {

    /**
     * Creates an AudienceRepublicService client with default settings (logging disabled).
     *
     * @param audienceRepublicVersions the API version to use
     * @param provider the provider identifier
     * @param token the authentication token
     * @return an instance of AudienceRepublicService
     */
    public static AudienceRepublicService getClient(AudienceRepublicVersions audienceRepublicVersions, String provider, String token){
        return new AudienceRepublicServiceImpl(provider, audienceRepublicVersions, token, false, LogLevel.INFO);
    }

    /**
     * Creates an AudienceRepublicService client with logging configuration.
     *
     * @param audienceRepublicVersions the API version to use
     * @param provider the provider identifier
     * @param token the authentication token
     * @param enableLogging whether to enable request/response logging
     * @param logLevel the log level to use (DEBUG, INFO, or ERROR)
     * @return an instance of AudienceRepublicService
     */
    public static AudienceRepublicService getClient(AudienceRepublicVersions audienceRepublicVersions, String provider, String token, boolean enableLogging, LogLevel logLevel){
        return new AudienceRepublicServiceImpl(provider, audienceRepublicVersions, token, enableLogging, logLevel);
    }

}
