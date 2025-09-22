package com.example.EmployeeManagementCrud.Service;

import com.example.EmployeeManagementCrud.Domain.*;
import com.example.EmployeeManagementCrud.Exception.EmployeeNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private SkillsRepo skillsRepo;

    @Transactional
    public Employee create(Employee e){
        Employee emp = new Employee();
        emp.setEmpName(e.getEmpName());
        emp.setSalary(e.getSalary());
        emp.setAddress(e.getAddress());
        Department d = departmentRepo.findById(e.getDepartment().getDeptId())
                .orElseThrow(()->new EmployeeNotFoundException("Department not found"));
        emp.setDepartment(d);
        List<Skills> s = e.getSkills().stream().map(sk-> skillsRepo.findById(sk.getSkillId())
                .orElseThrow(()->new EmployeeNotFoundException("Skills Not Found")))
                .collect(Collectors.toList());

        emp.setSkills(s);
        employeeRepo.save(emp);
        return emp;
    }

    public Optional<Employee> update(Long id, Employee e) {
        Optional<Employee> emp = employeeRepo.findById(id);

        if(emp.isPresent()){
            Employee employee = emp.get();
            if(e.getEmpName()!=null){
                employee.setEmpName(e.getEmpName());
            }
            if(e.getSalary()!=null){
                employee.setSalary(e.getSalary());
            }
            if(e.getAddress()!=null){
                employee.setAddress(e.getAddress());
            }
            if(e.getDepartment()!=null){
                employee.setDepartment(e.getDepartment());
            }
            if(e.getSkills()!=null && !e.getSkills().isEmpty()){
                employee.setSkills(e.getSkills());
            }
            return Optional.of(employeeRepo.save(employee));
        }
        else{
            throw new EmployeeNotFoundException("Id "+id+" Not Found");
        }
    }

    public String deleteEmployee(Long id){
        Employee e = employeeRepo.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));

        employeeRepo.deleteById(id);
        return "Employee deleted successfully";
    }

    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public Employee findById(Long id){
        Employee emp = employeeRepo.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Id "+id+" not found"));
        return emp;
    }
}
