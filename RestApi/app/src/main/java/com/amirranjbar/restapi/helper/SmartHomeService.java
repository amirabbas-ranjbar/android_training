package com.amirranjbar.restapi.helper;

import com.amirranjbar.restapi.apiResponse.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
public interface SmartHomeService {

    @GET("SmartHome?serialNumber=000003346ada")
    Call<ApiResponse> getSmarts();


}
