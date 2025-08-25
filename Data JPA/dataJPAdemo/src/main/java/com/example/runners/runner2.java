package com.example.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class runner2 implements ApplicationRunner{

    @Override  //(key:value)
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Application started with ApplicationRunner");
	}

}
