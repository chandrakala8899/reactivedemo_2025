package com.neoteric.webclientdemo.webclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class WebclientdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebclientdemoApplication.class, args);
	}

}
