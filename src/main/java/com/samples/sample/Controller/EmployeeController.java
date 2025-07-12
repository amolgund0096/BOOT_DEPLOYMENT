package com.samples.sample.Controller;

import org.springframework.web.bind.annotation.*;

import com.samples.sample.Entity.Employee;
import com.samples.sample.Service.EmployeeService;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*") 
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
    	return service.getEmployeeById(id);
    }
    
    
     
    @PostMapping
    public Employee create(@Valid @RequestBody Employee emp) {
        return service.save(emp);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    
    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee , @PathVariable Long id) {
    		return service.updateEmployee(id, employee);
    }
}

