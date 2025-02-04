package com.neoteric.webclientdemo.reactivethreaddemo.repository;

import com.neoteric.webclientdemo.reactivethreaddemo.entity.Fingerprints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FingerprintsRepository extends JpaRepository<Fingerprints,Long> {
}
