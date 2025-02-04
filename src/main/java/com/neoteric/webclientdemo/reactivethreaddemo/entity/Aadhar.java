package com.neoteric.webclientdemo.reactivethreaddemo.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "aadhar")
public class Aadhar {
    @jakarta.persistence.Id
    @Id
    private Long id;
    private String number;
    private String name;
}
