package org.spaceon.apijson;

import org.spaceon.apiconnection.ApiConnector;
import org.spaceon.apiendpoints.ApiFetchFactory;
import org.spaceon.apiendpoints.ProjectInfoEndPoint;

import java.io.IOException;

public class ResponseProjectInfo implements ResponseFactory{
    @Override
    public void jsonResponse() throws IOException {
        ApiFetchFactory apiFetchFactory = new ProjectInfoEndPoint();
        ApiConnector apiConnector = new ApiConnector(apiFetchFactory);
        apiFetchFactory.endPoint(apiConnector);
        String response = apiConnector.getResponse();
        System.out.println(response);
    }
}