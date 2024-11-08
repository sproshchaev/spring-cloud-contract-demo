package com.prosoft;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

    @Test
    void postString() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8100/hello";

        // Создаем тело запроса с именем
        String requestBody = "John Doe";

        // Устанавливаем заголовки, если нужно (например, для указания типа содержимого)
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "text/plain");

        // Создаем объект HttpEntity для передачи тела запроса и заголовков
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Отправляем POST-запрос
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        // Логируем ответ
        LOGGER.info("Response: {}", response.getBody());

        // Проверка, что ответ соответствует ожидаемому значению
        assertEquals("Hello, John Doe!", response.getBody(), "Ответ должен быть 'Hello, John Doe!'");
    }

}
