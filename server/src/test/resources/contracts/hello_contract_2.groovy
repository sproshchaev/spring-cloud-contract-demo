package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return hello"

    request {
        url "/hello"
        method GET()
    }

    response {
        status OK()
        body "Hello!"
    }
}
