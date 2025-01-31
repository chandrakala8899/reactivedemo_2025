package com.neoteric.webclientdemo.webclientdemo;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientExample {

    private final WebClient webClient;

    public WebClientExample(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }


    public Mono<String> postExampleData() {
        return webClient.post()
                //end point
                .uri("/posts/1")
                .retrieve()
                .bodyToMono(String.class);
    }


    public Mono<String> getExampleData() {
        return webClient.get()
                .uri("/posts/1")
                .retrieve()
                .bodyToMono(String.class);
    }

}

