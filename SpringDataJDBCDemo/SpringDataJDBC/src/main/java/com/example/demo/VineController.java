package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class VineController {
	
	@Autowired //autowire jdbc template
	private JdbcTemplate jdbcTemplate; //
	
	//jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS vines (id SERIAL, name VARCHAR(255), country VARCHAR(255))");
	
	//jdbcTemplate.update("INSERT INTO vines (name, country) VALUES (?, ?)", "Chardonnay", "France");


}
