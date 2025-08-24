package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@configuration + @componentscan(basebackage="com.vine") + @enableautoconfiguration
public class SpringBootDemoApplication {//boot starter class

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
		System.out.println("Spring Boot Application is running! Vine");
	}

}
