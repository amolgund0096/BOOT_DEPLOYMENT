package com.samples.sample.Service;


import org.springframework.stereotype.Service;

import com.samples.sample.Entity.Employee;
import com.samples.sample.Repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }
    
    public Employee getEmployeeById(Long id) {
    	return (Employee) repo.findById(id).orElse(null);
    }

    public Employee save(Employee employee) {
        return repo.save(employee);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    
    public Employee updateEmployee(Long id , Employee updateEmployee) {
    	return (Employee) repo.findById(id).map(employee->{
    		((Employee) employee).setName(updateEmployee.getName());
    		((Employee) employee).setRole(updateEmployee.getRole());
    		((Employee) employee).setContact(updateEmployee.getContact());
    		((Employee) employee).setEducation(updateEmployee.getEducation());
    		((Employee) employee).setEmail(updateEmployee.getEmail());
    		return repo.save(employee);
    	}).orElse(null);
    }
}

