package contracts

import org.springframework.cloud.contract.spec.Contract

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
