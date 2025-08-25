package com.example.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class runners implements CommandLineRunner {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//key:value

	//only values
	public void run(String... args) throws Exception {
		System.out.println("Application started with CommandLineRunner");
		// insert value into db
		System.out.println(Arrays.toString(args));
		entityManager.createNativeQuery("INSERT INTO employee (name, department, salary) VALUES ('John Doe', 'IT', 60000)").executeUpdate();
	}

}
