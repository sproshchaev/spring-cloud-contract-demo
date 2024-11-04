package com.prosoft.server.contract;

import com.prosoft.server.ServerApplication;
import com.prosoft.server.controller.Controller;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ServerApplication.class)
public class BaseClass {

    @Autowired
    Controller controller;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(controller);
    }
}
