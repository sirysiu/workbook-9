package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapp")
public class HelloWorldController {

    @GetMapping(path = "/sayhello")
    public Cat sayHello() {
        // Assuming Cat is a class with a constructor that accepts two strings.
        return new Cat("Glazed ...", "cat");
    }
}
