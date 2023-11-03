package org.acme;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api/test")
@RegisterRestClient(configKey = "external-api")
public interface RestClientApi {
    @GET
    @Retry(maxRetries = 3, delay = 500)
    @Fallback(ClientApiFallback.class)
    String getFruitByName();

    @GET
    @CircuitBreaker(requestVolumeThreshold = 2, failureRatio = 0.75, delay = 10000)
    String getFruitByColor();
}
