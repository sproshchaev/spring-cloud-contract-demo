package contracts

import org.springframework.cloud.contract.spec.Contract

/**
 * Этот контракт тестирует базовый ответ от сервиса
 * на GET-запрос к эндпоинту `/hello`.
 * Ожидается, что сервис вернет строку "Hello!" в теле ответа
 * при GET-запросе на `/hello`.
 * Для его использования необходимо переместить в resources\contracts
 */
Contract.make {
    description "should return hello for GET request"

    request {
        url "/hello"
        method GET()
    }

    response {
        status OK()
        body "Hello!"
    }
}
