package com.task.techbridge.Interfaces;

import com.task.techbridge.Model.EmployeeResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("employees")
    Call<EmployeeResponse> getEmployee();
}
