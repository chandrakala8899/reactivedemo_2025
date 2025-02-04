package com.neoteric.webclientdemo.reactivethreaddemo.controller;

import com.neoteric.webclientdemo.reactivethreaddemo.entity.Aadhar;
import com.neoteric.webclientdemo.reactivethreaddemo.entity.Address;
import com.neoteric.webclientdemo.reactivethreaddemo.entity.Eyes;
import com.neoteric.webclientdemo.reactivethreaddemo.entity.Fingerprints;
import com.neoteric.webclientdemo.reactivethreaddemo.service.AadharService;
import com.neoteric.webclientdemo.reactivethreaddemo.service.AddressService;
import com.neoteric.webclientdemo.reactivethreaddemo.service.EyesService;
import com.neoteric.webclientdemo.reactivethreaddemo.service.FingerprintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive")
public class ReactiveController {

    @Autowired
    private AadharService aadharService;
    @Autowired private AddressService addressService;
    @Autowired private FingerprintsService fingerprintsService;
    @Autowired private EyesService eyesService;

    @GetMapping("/aadhar/{id}")
    public Mono<Aadhar> getAadhar(@PathVariable Long id) {
        return aadharService.getAadhar(id);
    }

    @GetMapping("/address/{id}")
    public Mono<Address> getAddress(@PathVariable Long id) {
        return addressService.getAddress(id);
    }

    @GetMapping("/fingerprints/{id}")
    public Mono<Fingerprints> getFingerprints(@PathVariable Long id) {
        return fingerprintsService.getFingerprints(id);
    }

    @GetMapping("/eyes/{id}")
    public Mono<Eyes> getEyes(@PathVariable Long id) {
        return eyesService.getEyes(id);
    }
}
