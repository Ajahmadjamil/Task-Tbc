package com.task.techbridge.Model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class EmployeeResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private List<Employee> data;

    @SerializedName("message")
    private String message;

    // Getters and setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
