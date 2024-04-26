package org.spaceon.apiendpoints;

import org.spaceon.apiconnection.ApiConnector;

import java.io.IOException;

public interface ApiFetchFactory {
    void endPoint(ApiConnector apiConnector) throws IOException;
}
