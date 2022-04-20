package com.javatechie.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.javatechie.reactive.dto.ProductDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private WebClient myWebClient;


    public Flux<ProductDto> getProducts(){
    	
    	return myWebClient.get()
    			.uri("http://localhost:9292/products")
    			.retrieve()
    			.bodyToFlux(ProductDto.class);
    	
    	
    }

    public Mono<ProductDto> getProduct(int id){
       
    	return myWebClient.get()
    			.uri("http://localhost:9292/products/{id}", id)
    			.retrieve()
    			.bodyToMono(ProductDto.class);
    }

    public Mono<ProductDto> saveProduct(ProductDto productDtoMono){
       
    	return myWebClient.post()
    			.uri("http://localhost:9292/products")
    			.body(Mono.just(productDtoMono), ProductDto.class)
    			.retrieve()
    			.bodyToMono(ProductDto.class);
    }
}
