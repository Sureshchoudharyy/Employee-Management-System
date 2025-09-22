package com.example.EmployeeManagementCrud.Controller;

import com.example.EmployeeManagementCrud.Domain.Address;
import com.example.EmployeeManagementCrud.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address create(@RequestBody Address address){
        return addressService.create(address);
    }

    @PutMapping("/{id}")
    public Optional<Address> update(@PathVariable("id") Long id, @RequestBody Address a){
        return addressService.update(id,a);
    }

    @DeleteMapping("/{id}")
    public Address delete(@PathVariable("id") Long id){
        return addressService.delete(id);
    }

    @GetMapping
    public List<Address> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable Long id){
        return addressService.findById(id);
    }

}