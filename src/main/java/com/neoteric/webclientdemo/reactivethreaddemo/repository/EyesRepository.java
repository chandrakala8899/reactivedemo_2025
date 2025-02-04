package com.neoteric.webclientdemo.reactivethreaddemo.repository;

import com.neoteric.webclientdemo.reactivethreaddemo.entity.Eyes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EyesRepository extends JpaRepository<Eyes,Long> {
}
