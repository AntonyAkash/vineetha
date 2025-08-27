package com.example.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.controller.EmployeeController;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//@Component
public class runners implements CommandLineRunner {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EmployeeController employeeController;

	//only values - non option args
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("Application started with CommandLineRunner");
		// insert value into db
		for(String arg : args) {
			System.out.println(arg);
		}
		
		entityManager.createNativeQuery("INSERT INTO employee (name, department, salary) VALUES ('John Doe', 'IT', 60000)").executeUpdate();

        System.out.println("All Employees: " + employeeController.getAllEmployees());//testing our Employeecontroller
	}
	
	

}
