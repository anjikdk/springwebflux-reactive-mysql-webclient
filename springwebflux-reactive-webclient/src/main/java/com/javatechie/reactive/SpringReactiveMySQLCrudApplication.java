package com.javatechie.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SpringReactiveMySQLCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveMySQLCrudApplication.class, args);
	}

	@Bean
	public WebClient myWebClient(WebClient.Builder webClientBuilder) {
		return webClientBuilder
				.baseUrl("")
				.build();
	}

}
