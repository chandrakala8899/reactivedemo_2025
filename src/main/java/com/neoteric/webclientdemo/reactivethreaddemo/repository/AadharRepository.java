package com.neoteric.webclientdemo.reactivethreaddemo.repository;

import com.neoteric.webclientdemo.reactivethreaddemo.entity.Aadhar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AadharRepository extends JpaRepository<Aadhar,Long> {
}
