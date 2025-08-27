package com.example.model;

import java.io.Serializable;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@SqlResultSetMapping(
	    name = "EmployeeDTOMapper",
	    classes = {
	        @ConstructorResult(
	            targetClass = Employee.class,
	            columns = {
	                @ColumnResult(name = "name", type = String.class),
	                @ColumnResult(name = "salary", type = Double.class)
	            }
	        )
	    }
	)

	@NamedNativeQuery(
	    name = "Employee.findNameAndSalary",
	    query = "SELECT name, salary FROM employees WHERE department = :dept",
	    resultSetMapping = "EmployeeDTOMapper"
	)

@Entity //java object to jpa entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String name;
	@NonNull
	private String department;
	@NonNull
	private double salary;
}
