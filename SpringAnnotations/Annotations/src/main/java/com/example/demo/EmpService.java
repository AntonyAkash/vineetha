package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmpService {
	
	//@Autowired
	// @Resource
	//@Qualifier("vinejdbcrepo") //prdeifined //user defined class
	private Irepo vineJPArepo;//has-a
	
	@Value("#{vinejdbcrepo}")
	private Irepo vineJPAreponew;
	// Diffrence between @Autowired and @Resource
	 
	 //Autowired -> byType @qualifier name
	 //Resource -> name bytype @qualifier
	 
	 
	 
	 
	//No unique bean of type 'com.example.demo.Irepo' available: expected single matching bean but found 2: vinerepo,vinejdbcrepo	
    //three ways to resoleve
	//@Qualifier("vinejdbcrepo") //user defined class
	//@primary
	//beanname==variable name
}
