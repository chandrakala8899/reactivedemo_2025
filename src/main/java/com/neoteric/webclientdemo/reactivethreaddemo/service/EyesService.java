package com.neoteric.webclientdemo.reactivethreaddemo.service;

import com.neoteric.webclientdemo.reactivethreaddemo.entity.Eyes;
import com.neoteric.webclientdemo.reactivethreaddemo.repository.EyesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Service
public class EyesService {

    @Autowired
    private EyesRepository eyesRepository;

    // 🔵 Blocking Method (Non-Reactive)
    public Eyes getEyesSync(Long id) {
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        return eyesRepository.findById(id).orElse(null);
    }

    // 🟢 Async Method for Reactive
    @Async
    public CompletableFuture<Eyes> getEyesAsync(Long id) {
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        return CompletableFuture.completedFuture(eyesRepository.findById(id).orElse(null));
    }

    public Mono<Eyes> getEyes(Long id) {
        return Mono.fromFuture(getEyesAsync(id));
    }
}

