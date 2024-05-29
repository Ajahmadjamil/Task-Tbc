package com.task.techbridge.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.task.techbridge.Adapters.EmployeeAdapter;
import com.task.techbridge.Model.Employee;
import com.task.techbridge.Model.EmployeeResponse;
import com.task.techbridge.R;
import com.task.techbridge.Instances.RetrofitInstance;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button uploadPost;
    private RecyclerView recyclerView;
    private EmployeeAdapter employeeAdapter;
    public static String api = "https://dummy.restapiexample.com/api/v1/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadPost = findViewById(R.id.uploadPost);
        recyclerView = findViewById(R.id.employeeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        employeeAdapter = new EmployeeAdapter();
        recyclerView.setAdapter(employeeAdapter);

        uploadPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UploadPostActivity.class);
                startActivity(intent);
            }
        });

        // Fetch employees
        RetrofitInstance.getInstance().getApiInterface().getEmployee().enqueue(new Callback<EmployeeResponse>() {
            @Override
            public void onResponse(Call<EmployeeResponse> call, Response<EmployeeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Employee> employeeList = response.body().getData();
                    // Log the received data
                    for (Employee employee : employeeList) {
                        Log.d(TAG, "Employee ID: " + employee.getId());
                        Log.d(TAG, "Employee Name: " + employee.getEmployeeName());
                        Log.d(TAG, "Employee Salary: " + employee.getEmployeeSalary());
                        Log.d(TAG, "Employee Age: " + employee.getEmployeeAge());
                    }

                    employeeAdapter.setEmployees(employeeList);
                } else {
                    Log.d(TAG, "Response not successful: " + response.code());
                    // Log the error message if available
                    if (response.errorBody() != null) {
                        try {
                            Log.d(TAG, "Error message: " + response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<EmployeeResponse> call, Throwable t) {
                Log.e(TAG, "API call failed: " + t.getMessage());
                // Handle failure, e.g., show a toast message
                Toast.makeText(MainActivity.this, "API call failed", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
