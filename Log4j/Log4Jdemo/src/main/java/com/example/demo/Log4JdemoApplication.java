package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4JdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Log4JdemoApplication.class, args);
		new Controller();
	}

}
