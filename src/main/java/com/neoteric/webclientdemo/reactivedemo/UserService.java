package com.neoteric.webclientdemo.reactivedemo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Executor asyncExecutor;

    public UserService(UserRepository userRepository, Executor asyncExecutor) {
        this.userRepository = userRepository;
        this.asyncExecutor = asyncExecutor;
    }


    @Async
    public CompletableFuture<User> getUserById(Long id) {
        return CompletableFuture.supplyAsync(() ->
                        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")),
                asyncExecutor
        );

    }
    public CompletableFuture<String> fetchUsersConcurrently() {
        CompletableFuture<User> user1 = getUserById(1L);
        CompletableFuture<User> user2 = getUserById(2L);
        CompletableFuture<User> user3 = getUserById(3L);

        // Combine all futures
        return CompletableFuture.allOf(user1, user2, user3)
                .thenApply(v -> "User 1: " + user1.join().getName() +
                        ", User 2: " + user2.join().getName() +
                        ", User 3: " + user3.join().getName());
    }
}


