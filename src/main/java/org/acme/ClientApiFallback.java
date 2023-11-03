package org.acme;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

public class ClientApiFallback implements FallbackHandler<String> {

    @Override
    public String handle(ExecutionContext executionContext) {
        return executionContext.getFailure().getMessage();
    }
}
