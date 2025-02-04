package com.neoteric.webclientdemo.reactivedemo;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class CustomerWebClientService {

    private WebClient webClient;

    public CustomerWebClientService( WebClient.Builder webclientBuilder){
   this.webClient=webclientBuilder.baseUrl("http://localhost:8080/api/users").build();
    }

    public Flux<User> getAllUsers(){
        return webClient.get()
                .retrieve()
                .bodyToFlux(User.class);
    }

    public Mono<User> getUserById(Long id) {
        return webClient.get()
                .uri("{/id}", id)
                .retrieve()
                .bodyToMono(User.class);
    }
}
