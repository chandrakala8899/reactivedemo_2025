package com.neoteric.webclientdemo.reactive_2025;

import reactor.core.publisher.Mono;

public class DBService {
  public Mono<String> getData(){
      try {
          Thread.sleep(5000);

      } catch (Exception e){

      }
      return Mono.just(" from db service");
  }
}
