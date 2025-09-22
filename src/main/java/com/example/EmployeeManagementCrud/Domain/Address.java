package com.example.EmployeeManagementCrud.Domain;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private Long addId;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    public Address(){}

    public Address(Long addId, String city, String state) {
        this.addId = addId;
        this.city = city;
        this.state = state;
    }

    public Long getAddId() {
        return addId;
    }

    public void setAddId(Long addId) {
        this.addId = addId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
