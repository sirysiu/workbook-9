package com.pluralsight.rest;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="rest/products")
public class ProductController {

    @GetMapping(path="/{id}")
    public Product findByInt(@PathVariable("id") Integer productId){
        return new Product(1.99, "Plolish", "item", 1);
    }

    @GetMapping
    List<Product> findAll(){
        List<Product> results = new ArrayList<>();
        results.add(new Product(1.99, "nails", "art", 2));
        return results;
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        System.out.println(product);
        return product;
    }


    @DeleteMapping
    @RequestMapping(path="/{id}")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer product){
        System.out.println(product + "deleted"
        );    }
}
