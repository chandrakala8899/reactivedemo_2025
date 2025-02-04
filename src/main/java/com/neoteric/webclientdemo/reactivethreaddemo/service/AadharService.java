package com.neoteric.webclientdemo.reactivethreaddemo.service;

import com.neoteric.webclientdemo.reactivethreaddemo.entity.Aadhar;
import com.neoteric.webclientdemo.reactivethreaddemo.repository.AadharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Service
public class AadharService {

    @Autowired
    private AadharRepository aadharRepository;

    // 🔵 Blocking Method
    public Aadhar getAadharSync(Long id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return aadharRepository.findById(id).orElse(null);
    }

    // 🟢 Async Method for Reactive
    @Async
    public CompletableFuture<Aadhar> getAadharAsync(Long id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(aadharRepository.findById(id).orElse(null));
    }

    public Mono<Aadhar> getAadhar(Long id) {
        return Mono.fromFuture(getAadharAsync(id));
    }
}

