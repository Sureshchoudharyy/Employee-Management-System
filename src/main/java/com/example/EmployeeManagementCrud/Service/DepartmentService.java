package com.example.EmployeeManagementCrud.Service;

import com.example.EmployeeManagementCrud.Domain.Department;
import com.example.EmployeeManagementCrud.Domain.DepartmentRepo;
import com.example.EmployeeManagementCrud.Exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    public Department create(Department d){
        return departmentRepo.save(d);
    }

    public Optional<Department> update(Long id, Department d){
        Optional<Department> dept = departmentRepo.findById(id);
        if(dept.isPresent()){
            Department department = dept.get();
            if(d.getDeptName()!=null){
                department.setDeptName(d.getDeptName());
            }
            return Optional.of(departmentRepo.save(department));
        }
        else{
            throw new EmployeeNotFoundException("Id "+id+" not found");
        }
    }

    public Department delete(Long id){
        Department d = departmentRepo.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Id "+id+" not found"));
        departmentRepo.delete(d);
        return d;
    }

    public List<Department> findAll(){
        return departmentRepo.findAll();
    }

    public Department findById(Long id){
        Department d = departmentRepo.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Id "+id+" not found"));
        return d;
    }
}
