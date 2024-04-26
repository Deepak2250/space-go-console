package org.spaceon.apiendpoints;

import org.spaceon.apiconnection.ApiConnector;

import java.io.IOException;

public class ProjectInfoEndPoint implements ApiFetchFactory {

    @Override
    public void endPoint(ApiConnector apiConnector) throws IOException {

        apiConnector.fetchApi("https://techport.nasa.gov/api/projects/");
        System.out.println("it passed me");
    }
}
