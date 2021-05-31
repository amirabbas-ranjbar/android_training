package com.amirranjbar.restapi.apiResponse;

import com.amirranjbar.restapi.models.SmartHomes;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class ApiResponse {
    public boolean status;
    public String message;
    public SmartHomes data;
    public int errorCode;

}
