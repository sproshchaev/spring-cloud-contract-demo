package contracts

import org.springframework.cloud.contract.spec.Contract

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
