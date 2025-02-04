package com.neoteric.webclientdemo.reactivethreaddemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

    @Id
    private Long id;
    private String city;
    private String state;
}
