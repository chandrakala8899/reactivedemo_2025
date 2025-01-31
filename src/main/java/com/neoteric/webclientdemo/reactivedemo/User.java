package com.neoteric.webclientdemo.reactivedemo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user",schema = "userDetails")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public User() {}

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
}
