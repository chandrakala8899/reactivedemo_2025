package com.neoteric.webclientdemo.reactivedemo;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Flux<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return Flux.fromIterable(users);
    }


    public Mono<User> getUserById(Long id) {
         return Mono.justOrEmpty(userRepository.findById(id));

    }

}


