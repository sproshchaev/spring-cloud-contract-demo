package com.prosoft.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/hello")
    public String hello() {
        LOGGER.info("Incoming GET request to /hello");
        return "Hello!";
    }

    @PostMapping("/hello")
    public String helloWithName(@RequestBody String name) {
        LOGGER.info("Incoming POST request to /hello with name: {}", name);
        return String.format("Hello, %s!", name);
    }

}
