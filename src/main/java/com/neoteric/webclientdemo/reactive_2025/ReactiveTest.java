package com.neoteric.webclientdemo.reactive_2025;

import reactor.core.publisher.Mono;

public class ReactiveTest {
    public static void main(String[] args) {
        HelloWorldReactiveService helloWorldReactiveService = new HelloWorldReactiveService();

        String result = helloWorldReactiveService.sayHi();
        System.out.println(result);

        Mono<String> reactiveResult = helloWorldReactiveService.reactiveSayHi(0);

        reactiveResult.subscribe(
                dbdata -> System.out.println(dbdata),      // OnNext: Handles emitted data
                error -> System.out.println(error),        // OnError: Handles errors
                () -> System.out.println("===== OnCompleted") // OnComplete: Called when stream completes
        );

        System.out.println("reactive "  + reactiveResult);

        Mono<String> reactiveResult2 = helloWorldReactiveService.reactiveSayHi(10);

        reactiveResult2.subscribe(
                dbdata -> System.out.println(dbdata),      // OnNext: Handles emitted data
                error -> System.out.println(error),        // OnError: Handles errors
                () -> System.out.println("===== OnCompleted") // OnComplete: Called when stream completes
        );
        System.out.println( "reactive 2" + reactiveResult2);

    }


}

