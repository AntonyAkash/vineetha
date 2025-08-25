package com.example.service;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getEmployeeByName(String name);
    List<Employee> getAllEmployees();
    Employee updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
}
