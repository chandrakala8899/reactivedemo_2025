package com.neoteric.webclientdemo.reactivedemo;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/test/users")
public class WebClientTestController {

    private final CustomerWebClientService customerWebClientService;

    public WebClientTestController(CustomerWebClientService customerWebClientService) {
        this.customerWebClientService = customerWebClientService;
    }
    @GetMapping
    public Flux<User> getAllCustomers() {
        return customerWebClientService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Mono<User> getCustomerById(@PathVariable Long id) {
        return customerWebClientService.getUserById(id);
    }
}

