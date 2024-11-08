package com.prosoft;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureStubRunner(ids = {"com.prosoft:server:+:stubs:8100"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ContractIntegrationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContractIntegrationTest.class);

    @Test
    void getString() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8100/hello";
        String response = restTemplate.getForObject(url, String.class);
        LOGGER.info("Response: {}", response);
        assertEquals("Hello!", response, "Ответ должен быть 'Hello!'");
    }

}
