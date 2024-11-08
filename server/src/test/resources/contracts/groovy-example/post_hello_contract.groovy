package contracts

import org.springframework.cloud.contract.spec.Contract

/**
 * Этот контракт тестирует персонализированный ответ от сервиса
 * на POST-запрос к эндпоинту `/hello`, когда в теле запроса передано имя.
 * Ожидается, что сервис вернет строку "Hello, John Doe!" в теле ответа
 * при POST-запросе на `/hello` с телом "John Doe".
 * Для его использования необходимо переместить в resources\contracts
 */
Contract.make {
    description "should return personalized hello for POST request"

    request {
        url "/hello"
        method POST()
        body "John Doe"
    }

    response {
        status OK()
        body "Hello, John Doe!"
    }
}
