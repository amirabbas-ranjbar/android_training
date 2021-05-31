package com.amirranjbar.restapi.apiResponse;

import com.amirranjbar.restapi.helper.RetrofitClient;
import com.amirranjbar.restapi.helper.SmartHomeService;

public class APIUtils {

    private APIUtils(){
    };

    public static final String API_URL = "https://srv.pardik.co/MirrorService/";

    public static SmartHomeService getSmartService(){
        return RetrofitClient.getClient(API_URL).create(SmartHomeService.class);
    }

}
