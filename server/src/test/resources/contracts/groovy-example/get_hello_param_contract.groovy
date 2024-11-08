package contracts

import org.springframework.cloud.contract.spec.Contract

/**
 * Этот контракт тестирует персонализированный ответ от сервиса
 * на GET-запрос к эндпоинту `/hello`, когда передан параметр `name`.
 * Ожидается, что сервис вернет строку "Hello, John!" в теле ответа
 * при параметре запроса `name=John`.
 * Для его использования необходимо переместить в resources\contracts
 */
Contract.make {
    description "should return personalized hello for GET request with name parameter"

    request {
        method 'GET'
        url '/hello' {
            queryParameters {
                parameter 'name': 'John'
            }
        }
    }

    response {
        status 200
        body "Hello, John!"
        headers {
            contentType(applicationJson())
        }
    }
}
