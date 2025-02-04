package com.neoteric.webclientdemo.reactivethreaddemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fingerprints")
public class Fingerprints {
    @Id
    private Long id;
    private String pattern;
}
