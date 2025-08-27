package com.example.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class MVCcontroller {//this is controller to demonstrate spring boot MVC
	//this controller is to demonstrate view resolver
	//http://localhost:8080/mvc/show
	//it will randomly show either welcomeVine.html or error page
	@GetMapping("/show")
	public String show() {
		try {
		if(new Random().nextBoolean()) {
			return "welcomeVine";//view name without extension or jsp name without extension
		}
		else {
			throw new RuntimeException("Simulated Error");
		}
		}
		catch(Exception e) {
			return "errorVine";//view name without extension or jsp name without extension
		}
	}
}
