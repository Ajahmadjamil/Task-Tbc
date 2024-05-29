package com.task.techbridge.Model;
import com.google.gson.annotations.SerializedName;

public class Employee {
    @SerializedName("id")
    private int id;

    @SerializedName("employee_name")
    private String employeeName;

    @SerializedName("employee_salary")
    private int employeeSalary;

    @SerializedName("employee_age")
    private int employeeAge;

    @SerializedName("profile_image")
    private String profileImage;

    // Constructor
    public Employee(int id, String employeeName, int employeeSalary, int employeeAge, String profileImage) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeAge = employeeAge;
        this.profileImage = profileImage;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
