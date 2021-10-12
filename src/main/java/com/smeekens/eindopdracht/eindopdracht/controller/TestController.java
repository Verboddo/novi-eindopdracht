package com.smeekens.eindopdracht.eindopdracht.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/test")
@RestController
public class TestController {

    @GetMapping(value ="/all")
    public String sayHelloWorld() {
        return "Hello World";
    }

}
