package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface Iservice {
	List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
