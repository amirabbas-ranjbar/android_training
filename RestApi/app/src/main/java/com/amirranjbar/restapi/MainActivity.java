package com.amirranjbar.restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.amirranjbar.restapi.apiResponse.APIUtils;
import com.amirranjbar.restapi.apiResponse.ApiResponse;
import com.amirranjbar.restapi.helper.SmartHomeService;
import com.amirranjbar.restapi.models.SmartHomes;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    SmartHomeService smartHomeService;
    ApiResponse apiResponse;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartHomeService = APIUtils.getSmartService();


    }


    public void btnOnClick(View v) {
        //get users list
        apiResponse = new ApiResponse();
        txtView = findViewById(R.id.txtview);
        Call<ApiResponse> call = smartHomeService.getSmarts();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    apiResponse = response.body();
                    SmartHomes smartHomes = apiResponse.data;
                    txtView.setText(smartHomes.deviceID);

                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}