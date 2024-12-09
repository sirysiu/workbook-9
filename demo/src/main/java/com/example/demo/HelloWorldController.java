package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapp")
public class HelloWorldController {

    @RequestMapping(path= "/sayhello", method = RequestMethod.GET)
    String sayHello() {
        return "Glazed ...";
    }
}
