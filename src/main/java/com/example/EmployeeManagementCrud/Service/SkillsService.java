package com.example.EmployeeManagementCrud.Service;

import com.example.EmployeeManagementCrud.Domain.Skills;
import com.example.EmployeeManagementCrud.Domain.SkillsRepo;
import com.example.EmployeeManagementCrud.Exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsService {
    @Autowired
    private SkillsRepo skillsRepo;

    public Skills create(Skills s){
        return skillsRepo.save(s);
    }

    public Optional<Skills> update(Long id, Skills s){
        Optional<Skills> sk = skillsRepo.findById(id);

        if(sk.isPresent()){
            Skills skills = sk.get();
            if(s.getSkillsName()!=null){
                skills.setSkillsName(s.getSkillsName());
            }
            return Optional.of(skillsRepo.save(skills));
        }
        else{
            throw new EmployeeNotFoundException("Id "+id+" Not Found");
        }
    }

    public Skills delete(Long id){
        Skills sk = skillsRepo.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Id "+id+" not found"));
        skillsRepo.delete(sk);
        return sk;
    }

    public List<Skills> findAll(){
        return skillsRepo.findAll();
    }

    public Skills findById(Long id){
        Skills sk = skillsRepo.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Id "+id+" not found"));
        return sk;
    }
}
