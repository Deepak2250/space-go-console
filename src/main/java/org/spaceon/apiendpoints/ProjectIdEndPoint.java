package org.spaceon.apiendpoints;

import org.spaceon.apiconnection.ApiConnector;

import java.io.IOException;

public class ProjectIdEndPoint implements ApiFetchFactory{
    @Override
    public void endPoint(ApiConnector apiConnector) throws IOException {
        apiConnector.fetchApi("https://techport.nasa.gov/api/projects?updatedSince=2024-04-04");
    }
}
