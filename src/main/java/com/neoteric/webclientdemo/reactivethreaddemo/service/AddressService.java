package com.neoteric.webclientdemo.reactivethreaddemo.service;

import com.neoteric.webclientdemo.reactivethreaddemo.entity.Address;
import com.neoteric.webclientdemo.reactivethreaddemo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address getAddressSync(Long id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return addressRepository.findById(id).orElse(null);
    }

    @Async
    public CompletableFuture<Address> getAddressAsync(Long id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(addressRepository.findById(id).orElse(null));
    }

    public Mono<Address> getAddress(Long id) {
        return Mono.fromFuture(getAddressAsync(id));
    }
}
