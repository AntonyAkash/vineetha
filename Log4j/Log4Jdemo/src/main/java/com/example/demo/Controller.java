package com.example.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Controller {
		public void doSomething() {
		log.info("This is an info message");
		log.warn("This is a warning message");
		log.error("This is an error message");
		log.debug("This is a debug message");
		log.trace("This is a trace message");
	}
 
}
