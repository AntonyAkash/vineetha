package com.vine;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		//entire bean life  cycle is managed by spring container _> creation of bean, maintenance of bean and deletion of bean
		//predefineds class we need create object of that class via java based configuration and maintenace and deletion will be done by spring container
	}
}
