package com.example.EmployeeManagementCrud.Controller;

import com.example.EmployeeManagementCrud.Domain.Department;
import com.example.EmployeeManagementCrud.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department create(@RequestBody Department d){
        return departmentService.create(d);
    }

    @PutMapping("/{id}")
    public Optional<Department> update(@PathVariable("id") Long id, @RequestBody Department d){
        return departmentService.update(id,d);
    }

    @DeleteMapping("/{id}")
    public Department delete(@PathVariable("id") Long id){
        return departmentService.delete(id);
    }

    @GetMapping
    public List<Department> findAll(){
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id){
        return departmentService.findById(id);
    }

}