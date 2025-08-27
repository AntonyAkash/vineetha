package com.example.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


//@Component
@Order(2) // Order of execution if multiple runners are present
public class runner2 implements ApplicationRunner{

    @Override  //(key:value) options args
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Application started with ApplicationRunner");
		for(String name : args.getOptionNames()) {
			System.out.println(name + " = *" + args.getOptionValues(name) + "from non option args" );
		}
	}

}
