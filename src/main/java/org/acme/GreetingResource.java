package org.acme;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class GreetingResource {

    @RestClient
    RestClientApi restClientApi;

    @GET
    @Path("/retry")
    public String retry() {
        return restClientApi.getFruitByName();
    }

    @GET
    @Path("/circuitBreaker")
    public String circuitBreaker() {
        return restClientApi.getFruitByColor();
    }
}
