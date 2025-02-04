package com.neoteric.webclientdemo.reactive_2025;

import reactor.core.publisher.Mono;

public class ReactiveTest {
    public static void main(String[] args) throws InterruptedException {


        HelloWorldReactiveService helloWorldReactiveService = new HelloWorldReactiveService();
        Long startTime =    System.currentTimeMillis();

        String resultHi = helloWorldReactiveService.sayHi();
        System.out.println(resultHi);


        String resultHello = helloWorldReactiveService.sayHello();
        System.out.println(resultHello);

        Long endTime =  System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000);

        System.out.println(" my job is done ");   // main thread will be blocked until we get response from say hi and say hello as well
                                                  // total blocked time  of main thread is 15 sec  = say hi is 10 sec + say hello is 5sec


        long startTime1 = System.currentTimeMillis();

        String reactiveHi = helloWorldReactiveService.reactiveSayHi().block();
        System.out.println(reactiveHi);

        String reactiveHello = helloWorldReactiveService.reactiveSayHello().block();
        System.out.println(reactiveHello);

        Mono<String> reactiveResult = helloWorldReactiveService.reactiveSayHi();
        Mono<String> reactiveResult2 = helloWorldReactiveService.reactiveSayHello();

        reactiveResult.subscribe(
                dbdata -> System.out.println(dbdata),      // OnNext: Handles emitted data
                error -> System.out.println(error),        // OnError: Handles errors
                () -> System.out.println("===== OnCompleted") // OnComplete: Called when stream completes
        );

        reactiveResult2.subscribe(
                dbdata -> System.out.println(dbdata),
                error -> System.out.println(error),
                () -> System.out.println("===== OnCompleted")
        );

        long endtime1 = System.currentTimeMillis();
        System.out.println((endtime1 - startTime1) / 1000 + " sec");

        // Ensure main thread waits for async completion
        Thread.sleep(15000); // 15 sec to ensure both Mono complete
    }
}

