package org.spaceon.apijson;

import org.spaceon.apiconnection.ApiConnector;
import org.spaceon.apiendpoints.ApiFetchFactory;
import org.spaceon.apiendpoints.ProjectIdEndPoint;

import java.io.IOException;

public class ProjectIdResponseJson implements ResponseFactory{
    @Override
    public void jsonResponse() throws IOException {
        ApiFetchFactory apiFetchFactory = new ProjectIdEndPoint();
        ApiConnector apiConnector = new ApiConnector(apiFetchFactory);
        apiFetchFactory.endPoint(apiConnector);
        String response = apiConnector.getResponse();
        System.out.println(response);
    }
}
