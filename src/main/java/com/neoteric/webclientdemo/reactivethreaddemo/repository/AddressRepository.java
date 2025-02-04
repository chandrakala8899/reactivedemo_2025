package com.neoteric.webclientdemo.reactivethreaddemo.repository;

import com.neoteric.webclientdemo.reactivethreaddemo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
