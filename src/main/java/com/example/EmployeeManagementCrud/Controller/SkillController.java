package com.example.EmployeeManagementCrud.Controller;

import com.example.EmployeeManagementCrud.Domain.Skills;
import com.example.EmployeeManagementCrud.Service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private SkillsService skillsService;

    @PostMapping
    public Skills create(@RequestBody Skills s){
        return skillsService.create(s);
    }

    @PutMapping("/{id}")
    public Optional<Skills> update(@PathVariable("id") Long id, @RequestBody Skills s){
        return skillsService.update(id,s);
    }

    @DeleteMapping("/{id}")
    public Skills delete(@PathVariable("id") Long id){
        return skillsService.delete(id);
    }

    @GetMapping
    public List<Skills> findAll(){
        return skillsService.findAll();
    }

    @GetMapping("/{id}")
    public Skills getById(@PathVariable Long id){
        return skillsService.findById(id);
    }

}