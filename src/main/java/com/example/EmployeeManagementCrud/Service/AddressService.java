package com.example.EmployeeManagementCrud.Service;

import com.example.EmployeeManagementCrud.Domain.Address;
import com.example.EmployeeManagementCrud.Domain.AddressRepo;
import com.example.EmployeeManagementCrud.Exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;

    public Address create(Address a){
        return addressRepo.save(a);
    }

    public Optional<Address> update(Long id, Address a){
        Optional<Address> add = addressRepo.findById(id);
        if(add.isPresent()){
            Address address = add.get();
            if(a.getCity()!=null){
                address.setCity(a.getCity());
            }
            if(a.getState()!=null){
                address.setState(a.getState());
            }
            return Optional.of(addressRepo.save(address));
        }
        else{
            throw new EmployeeNotFoundException("Id "+id+" not found");
        }
    }

    public Address delete(Long id){
        Address a = addressRepo.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Id "+id+" not found"));
        addressRepo.delete(a);
        return a;
    }

    public List<Address> findAll(){
        return addressRepo.findAll();
    }

    public Address findById(Long id){
        Address a = addressRepo.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Id "+id+" not found"));
        return a;
    }
}
