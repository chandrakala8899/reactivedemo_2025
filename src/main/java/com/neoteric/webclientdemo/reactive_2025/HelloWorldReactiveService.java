package com.neoteric.webclientdemo.reactive_2025;

import reactor.core.publisher.Mono;
import java.time.Duration;

public class HelloWorldReactiveService {

    public String sayHi() {
        try {
            Thread.sleep(10000); // 10 seconds
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Hi";
    }

    public String sayHello() {
        try {
            Thread.sleep(5000); // 5 seconds
        } catch (Exception e) {

        }
        return "Hello";
    }

    public Mono<String> reactiveSayHi() {
        return Mono.just("Hi").delayElement(Duration.ofSeconds(10)); // Simulates 10 sec delay
    }

    public Mono<String> reactiveSayHello() {
        return Mono.just("Hello").delayElement(Duration.ofSeconds(5)); // Simulates 5 sec delay
    }


}