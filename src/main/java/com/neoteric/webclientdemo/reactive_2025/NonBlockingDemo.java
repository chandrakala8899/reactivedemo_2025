package com.neoteric.webclientdemo.reactive_2025;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import java.time.Duration;

public class NonBlockingDemo {
    public static void main(String[] args) throws InterruptedException {
        Mono<String> mono1 = nonBlockingMethod1();
        Mono<String> mono2 = nonBlockingMethod2();

        mono1.subscribe(System.out::println);
        mono2.subscribe(System.out::println);

        Thread.sleep(100); // Give enough time for async execution
    }

    static Mono<String> nonBlockingMethod1() {
        return Mono.just("Method 1 Executed")
                .delayElement(Duration.ofMillis(10))
                .subscribeOn(Schedulers.boundedElastic());
    }

    static Mono<String> nonBlockingMethod2() {
        return Mono.just("Method 2 Executed")
                .delayElement(Duration.ofMillis(10))
                .subscribeOn(Schedulers.boundedElastic());
    }
}
