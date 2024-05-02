package org.spaceon.apijson;

import org.spaceon.apiconnection.ApiConnector;
import org.spaceon.apiendpoints.ApiFetchFactory;
import org.spaceon.apiendpoints.ProjectIdEndPoint;

import java.io.IOException;

public class ProjectIdJson implements JsonResponseFactory {
    @Override
    public String jsonResponse() throws IOException {
        ApiFetchFactory apiFetchFactory = new ProjectIdEndPoint();
        ApiConnector apiConnector = new ApiConnector(apiFetchFactory);
        apiFetchFactory.endPoint(apiConnector);
        String response = apiConnector.getResponse();
        return response;
    }
}
