package com.vine;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com")
@PropertySource("src/main/resources/:application.properties")
public class AppConfig {
        //Spring JDBC configuration   //differnce between spring jdbc and spring data jdbc
	    // Configure DataSource (MySQL connection details)
	    //java based configuration
	    @Bean
	    public DataSource dataSource() {//spring container will call this method 
	    	//and return the object of DriverManagerDataSource to spring container
	        DriverManagerDataSource ds = new DriverManagerDataSource();
	        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");  // MySQL driver
	        ds.setUrl("jdbc:mysql://localhost:3306/testdb");    // your DB
	        ds.setUsername("root");                             // your DB user
	        ds.setPassword("0000");                     // your DB password
	        return ds;
	    }

	    // Configure JdbcTemplate bean
	    @Bean
	    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	        return new JdbcTemplate(dataSource);
	    }
	    
	    
	}

