package com.javatechie.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.reactive.dto.ProductDto;
import com.javatechie.reactive.entity.Product;

import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product,Integer> {
    Flux<ProductDto> findByPriceBetween(Double min, Double max);
}
