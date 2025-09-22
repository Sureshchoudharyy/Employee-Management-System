package com.example.EmployeeManagementCrud.Controller;

import com.example.EmployeeManagementCrud.Domain.Employee;
import com.example.EmployeeManagementCrud.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee create(@RequestBody Employee e){
        return employeeService.create(e);
    }

    @PutMapping("/{id}")
    public Optional<Employee> update(@PathVariable("id") Long id, @RequestBody Employee e){
        return employeeService.update(id,e);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id){
        return employeeService.findById(id);
    }

}