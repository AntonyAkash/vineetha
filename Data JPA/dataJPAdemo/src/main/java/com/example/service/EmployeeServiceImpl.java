package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.customexception.EmployeeNotfoundexception;
import com.example.model.Employee;
import com.example.repo.Emprepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private Emprepo employeeRepository;
	
	//INSIDE IF YOU WRITE NATIVE QUERY INSIDE THIS CLASS ALSO IT WILL WORK FINE	
	@PersistenceContext
    private EntityManager entityManager;
    
	
    @Override
    public Employee saveEmployee(Employee employee) {
    	log.info("Saving employee: {}", employee);
    	log.debug("Employee details - Name: {}, Department: {}, Salary: {}", employee.getName(), employee.getDepartment(), employee.getSalary());
    	log.warn("Ensure that the employee data is valid before saving.");
        return employeeRepository.save(employee);
    }

    @Override
    @Cacheable(value="employees", key="#id") // Caches the result of this method
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotfoundexception("Employee not found with id: " + id));
    }
    
    @Override
    public List<Employee> getEmployeeByName(String  name) {
        return employeeRepository.findByDepartment(name);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @CachePut(value="employees", key="#id") // Updates the cache for this method
    public Employee updateEmployee(int id, Employee employee) {
        Employee existing = getEmployeeById(id);
        existing.setName(employee.getName());
        existing.setDepartment(employee.getDepartment());
        existing.setSalary(employee.getSalary());
        return employeeRepository.save(existing);
    }

    @Override
    @CacheEvict(value="employees", key="#id") // Evicts the cache for this method
    //@CacheEvict(value="employees", allEntries=true) // Evicts all entries in the cache
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
    
 // Custom JPQL query
    public List<Employee> findByDepartment(String dept) {
        return entityManager.createQuery("SELECT e FROM Employee e WHERE e.department = :dept", Employee.class)
                .setParameter("dept", dept)
                .getResultList();
    }

}
