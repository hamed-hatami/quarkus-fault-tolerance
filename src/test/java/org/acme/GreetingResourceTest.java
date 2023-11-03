package org.acme;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testRetryEndpoint() {
        given()
                .when().get("/hello/retry")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy Reactive"));
    }

    @Test
    void testCircuitBreakerEndpoint() {
        given()
                .when().get("/hello/circuitBreaker")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy Reactive"));
    }

}