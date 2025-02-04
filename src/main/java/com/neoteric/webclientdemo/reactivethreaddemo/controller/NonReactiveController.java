package com.neoteric.webclientdemo.reactivethreaddemo.controller;


import com.neoteric.webclientdemo.reactivethreaddemo.entity.Aadhar;
import com.neoteric.webclientdemo.reactivethreaddemo.entity.Address;
import com.neoteric.webclientdemo.reactivethreaddemo.entity.Eyes;
import com.neoteric.webclientdemo.reactivethreaddemo.entity.Fingerprints;
import com.neoteric.webclientdemo.reactivethreaddemo.service.AadharService;
import com.neoteric.webclientdemo.reactivethreaddemo.service.AddressService;
import com.neoteric.webclientdemo.reactivethreaddemo.service.EyesService;
import com.neoteric.webclientdemo.reactivethreaddemo.service.FingerprintsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/non-reactive")
public class NonReactiveController {

    @Autowired private AadharService aadharService;
    @Autowired private AddressService addressService;
    @Autowired private FingerprintsService fingerprintsService;
    @Autowired private EyesService eyesService;

    @GetMapping("/aadhar/{id}")
    public ResponseEntity<Aadhar> getAadhar(@PathVariable Long id) {
        Aadhar aadhar = aadharService.getAadharSync(id);
        return aadhar != null ? ResponseEntity.ok(aadhar) : ResponseEntity.notFound().build();
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long id) {
        Address address = addressService.getAddressSync(id);
        return address != null ? ResponseEntity.ok(address) : ResponseEntity.notFound().build();
    }

    @GetMapping("/fingerprints/{id}")
    public ResponseEntity<Fingerprints> getFingerprints(@PathVariable Long id) {
        Fingerprints fingerprints = fingerprintsService.getFingerprintsSync(id);
        return fingerprints != null ? ResponseEntity.ok(fingerprints) : ResponseEntity.notFound().build();
    }
    @GetMapping("/eyes/{id}")
    public ResponseEntity<Eyes> getEyes(@PathVariable Long id) {
        Eyes eyes = eyesService.getEyesSync(id);
        return eyes != null ? ResponseEntity.ok(eyes) : ResponseEntity.notFound().build();
    }
}
