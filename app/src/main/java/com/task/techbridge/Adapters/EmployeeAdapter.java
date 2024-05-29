package com.task.techbridge.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.task.techbridge.Model.Employee;
import com.task.techbridge.R;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<Employee> employeeList = new ArrayList<>();

    public void setEmployees(List<Employee> employees) {
        this.employeeList = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_row, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.employeeName.setText(employee.getEmployeeName());
        holder.employeeSalary.setText(String.valueOf(employee.getEmployeeSalary()));
        holder.employeeAge.setText(String.valueOf(employee.getEmployeeAge()));
        holder.employeeId.setText(String.valueOf(employee.getId()));
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    static class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView employeeName, employeeSalary, employeeAge,employeeId;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            employeeName = itemView.findViewById(R.id.employeeName);
            employeeSalary = itemView.findViewById(R.id.employeeSalary);
            employeeAge = itemView.findViewById(R.id.employeeAge);
            employeeId = itemView.findViewById(R.id.emoloyeeId);
        }
    }
}
