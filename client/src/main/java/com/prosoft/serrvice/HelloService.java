package com.prosoft.serrvice;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    private final RestTemplate restTemplate;

    public HelloService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getHello() {
        String url = "http://localhost:8080/hello";
        return restTemplate.getForObject(url, String.class);
    }
}
