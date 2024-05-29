package com.task.techbridge.Instances;

import static com.task.techbridge.Activities.MainActivity.api;

import com.task.techbridge.Interfaces.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static RetrofitInstance instance;
    public static ApiInterface apiInterface;


    RetrofitInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface= retrofit.create(ApiInterface.class);

    }


    public static RetrofitInstance getInstance(){
        if (instance==null){
            instance = new RetrofitInstance();
        }
        return instance;
    }
    // Method to get the API interface
    public ApiInterface getApiInterface() {
        return apiInterface;
    }

}
