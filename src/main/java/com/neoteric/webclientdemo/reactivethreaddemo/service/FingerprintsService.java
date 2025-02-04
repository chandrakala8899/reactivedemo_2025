package com.neoteric.webclientdemo.reactivethreaddemo.service;

import com.neoteric.webclientdemo.reactivethreaddemo.entity.Fingerprints;
import com.neoteric.webclientdemo.reactivethreaddemo.repository.FingerprintsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Service
public class FingerprintsService {

    @Autowired
    private FingerprintsRepository fingerprintsRepository;

    // 🔵 Blocking Method (Non-Reactive)
    public Fingerprints getFingerprintsSync(Long id) {
        try {
            Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        return fingerprintsRepository.findById(id).orElse(null);
    }

    // 🟢 Async Method for Reactive
    @Async
    public CompletableFuture<Fingerprints> getFingerprintsAsync(Long id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(fingerprintsRepository.findById(id).orElse(null));
    }

    public Mono<Fingerprints> getFingerprints(Long id) {
        return Mono.fromFuture(getFingerprintsAsync(id));
    }
}

