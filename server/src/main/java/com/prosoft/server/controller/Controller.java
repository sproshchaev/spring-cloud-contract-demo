package com.prosoft.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/hello")
    public String hello() {
        LOGGER.info("incoming request");
        return "Hello!";
    }

}
