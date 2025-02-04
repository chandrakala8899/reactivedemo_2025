package com.neoteric.webclientdemo.reactivethreaddemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "eyes")
public class Eyes {
    @Id
    private Long id;
    private String irisPattern;
}
