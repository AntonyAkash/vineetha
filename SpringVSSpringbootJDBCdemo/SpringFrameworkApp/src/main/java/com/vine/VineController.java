package com.vine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VineController {
	
     @Autowired(required=true)//has-A relation// wiring - linking of dependent object
	 private  JdbcTemplate jdbcTemplate;
     
     @Autowired(required = false)
     private Irepository repo;
     
     @Autowired
     private Iservice service;//
     
 
     
     @Value("${time}")
     private int time; //dynamic way to get value from application.properties
     
     @Value("Vine")
     private String name; //static way
     
     @Value(10+2/2)
     private int someintvalue; //spel - spring expression language


	    // Insert user
	    @GetMapping("/addUser")
	    public String addUser(@RequestParam String name, @RequestParam String email) {
	        String sql = "INSERT INTO users(name, email) VALUES (?, ?)";
	        jdbcTemplate.update(sql, name, email);
	        return "User added: " + name;
	    }
}
