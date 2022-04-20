package com.javatechie.reactive.controller;

import com.javatechie.reactive.dto.ProductDto;
import com.javatechie.reactive.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public Flux<ProductDto> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProduct(@PathVariable int id){
        return service.getProduct(id);
    }

    @PostMapping
    public Mono<ProductDto> saveProduct(@RequestBody ProductDto productDtoMono){
        System.out.println("controller method called ...");
        return service.saveProduct(productDtoMono);
    }
    
    @PutMapping("/update/{id}")
    public Mono<ProductDto> updateProduct(@RequestBody ProductDto productDtoMono, @PathVariable("id") int id){
        System.out.println("controller method called ...");
        return service.updateProduct(productDtoMono, id);
    }
    
    @DeleteMapping("/delete/{id}")
    public Mono<ProductDto> deleteProduct(@PathVariable("id") int id){
        System.out.println("controller method called ...");
        return service.deleteProduct(id);
    }
    
}
