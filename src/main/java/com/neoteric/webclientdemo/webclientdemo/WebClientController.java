package com.neoteric.webclientdemo.webclientdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/webclient")
public class WebClientController {

    private final WebClientExample webClientExample;

    public WebClientController(WebClientExample webClientExample) {
        this.webClientExample = webClientExample;
    }

    @PostMapping("/save")
    public Mono<String> postData(){
        return webClientExample.postExampleData();
    }

    @GetMapping("/get")
    public Mono<String> fetchData() {
        return webClientExample.getExampleData();
    }
}
