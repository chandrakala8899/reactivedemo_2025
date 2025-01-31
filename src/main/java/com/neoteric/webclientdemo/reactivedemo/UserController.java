package com.neoteric.webclientdemo.reactivedemo;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public CompletableFuture<String> getUsers() {
        return userService.fetchUsersConcurrently();
    }

    @GetMapping("/{id}")
    public CompletableFuture<User> getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
