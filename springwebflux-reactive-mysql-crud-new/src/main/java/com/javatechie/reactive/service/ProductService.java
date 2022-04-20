package com.javatechie.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import com.javatechie.reactive.dto.ProductDto;
import com.javatechie.reactive.repository.ProductRepository;
import com.javatechie.reactive.utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public Flux<ProductDto> getProducts(){
        return repository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<ProductDto> getProduct(int id){
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    public Flux<ProductDto> getProductInRange(double min,double max){
        return repository.findByPriceBetween(min, max);
    }

    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono){
        System.out.println("service method called ...");
      return  productDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);
    }

    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono,int id){
       return repository.findById(id)
                .flatMap(p->productDtoMono.map(AppUtils::dtoToEntity)
                .doOnNext(e->e.setId(id)))
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);

    }

    public Mono<Void> deleteProduct(int id){
        return repository.deleteById(id);
    }
}
