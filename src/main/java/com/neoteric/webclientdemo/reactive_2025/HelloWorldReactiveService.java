package com.neoteric.webclientdemo.reactive_2025;

import reactor.core.publisher.Mono;

public class HelloWorldReactiveService {

    public String sayHi() {
        return " Hello world";
    }

    public Mono<String> reactiveSayHi(int i) {
//        DBService service = new DBService();
//      return  service.getData();

        if (i == 0) {
            return Mono.just("hello world");
        } else {
            return Mono.error(new RuntimeException("Error: i is not zero"));
        }
    }
}