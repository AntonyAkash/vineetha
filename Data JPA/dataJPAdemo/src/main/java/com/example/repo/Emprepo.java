package com.example.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Employee;


@Repository
public interface Emprepo extends JpaRepository<Employee, Integer> {
	
	// Derived query methods based on method names
	public List<Employee> findByName(String name);
	public List<Employee> findByDepartment(String department);
	
	List<Employee> findByNameIgnoreCase(String name);
	List<Employee> findByNameContaining(String keyword);        // LIKE %keyword%
	List<Employee> findByNameStartingWith(String prefix);       // LIKE prefix%
	List<Employee> findByNameEndingWith(String suffix);         // LIKE %suffix
	List<Employee> findByDepartmentIgnoreCase(String department);
	List<Employee> findByDepartmentContaining(String keyword);
	
	List<Employee> findBySalaryGreaterThan(double salary);
	List<Employee> findBySalaryLessThan(double salary);
	List<Employee> findBySalaryBetween(double min, double max);
	List<Employee> findBySalaryGreaterThanEqual(double salary);
	List<Employee> findBySalaryLessThanEqual(double salary);
	
	Optional<Employee> findById(int id);   // already comes with JpaRepository
	List<Employee> findByIdGreaterThan(int id);
	List<Employee> findByIdLessThan(int id);
	
	List<Employee> findByNameAndDepartment(String name, String department);
	List<Employee> findByNameOrDepartment(String name, String department);
	List<Employee> findByDepartmentAndSalaryGreaterThan(String department, double salary);
	List<Employee> findByNameContainingAndSalaryBetween(String keyword, double min, double max);
	
	List<Employee> findTop5ByOrderBySalaryDesc();   // highest 5 salaries
	List<Employee> findTop3ByDepartmentOrderBySalaryAsc(String department);
	
	boolean existsByName(String name);
	boolean existsByDepartment(String department);
	
	//1. JPQL Queries with @Query
	// JPQL query for exact match
    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> getEmployeesByName(@Param("name") String name);

    // JPQL with multiple fields
    @Query("SELECT e FROM Employee e WHERE e.department = :dept AND e.salary > :sal")
    List<Employee> getEmployeesByDeptAndSalary(@Param("dept") String dept, @Param("sal") double salary);

    // JPQL with LIKE (case-insensitive search)
    @Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Employee> searchByName(@Param("keyword") String keyword);

    // JPQL with sorting
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> getAllEmployeesSortedBySalary();
    
    //2. Native SQL Queries with @Query
    
    @Query(value = "SELECT * FROM employees WHERE department = :dept", nativeQuery = true)
    List<Employee> getByDepartmentNative(@Param("dept") String dept); //kubernates  auto scalling 

    @Query(value = "SELECT * FROM employees WHERE salary BETWEEN :min AND :max", nativeQuery = true)
    List<Employee> findBySalaryRangeNative(@Param("min") double min, @Param("max") double max);

    @Query(value = "SELECT * FROM employees ORDER BY salary DESC LIMIT 3", nativeQuery = true)
    List<Employee> getTop3HighestPaid();
    
    //UPDATE query
    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.salary = :sal WHERE e.department = :dept")
    int updateSalaryByDepartment(@Param("dept") String dept, @Param("sal") double sal);

    @Modifying
    @Transactional
    @Query("DELETE FROM Employee e WHERE e.salary < :minSalary")
    int deleteLowSalaryEmployees(@Param("minSalary") double minSalary);
    
    //Named native query example
    @Query(nativeQuery = true, name = "Employee.findNameAndSalary")
    List<Employee> findNamesAndSalarishfugsufgyhu(@Param("dept") String dept);
}
