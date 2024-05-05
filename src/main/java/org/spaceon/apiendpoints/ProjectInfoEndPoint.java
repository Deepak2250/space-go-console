package org.spaceon.apiendpoints;

import org.spaceon.apiconnection.ApiConnector;

import java.io.IOException;

public class ProjectInfoEndPoint implements ApiFetchFactory {

    private int id;
    public ProjectInfoEndPoint(int id){
        this.id = id;
    }

    @Override
    public void endPoint(ApiConnector apiConnector) throws IOException {

        try {
            apiConnector.fetchApi("https://techport.nasa.gov/api/projects/" + id);
            System.out.println("it passed me");
        }
        catch (NullPointerException e){
            e.getCause();
        }
    }
}
