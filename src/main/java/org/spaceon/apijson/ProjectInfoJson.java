package org.spaceon.apijson;

import com.google.gson.Gson;
import org.spaceon.apiconnection.ApiConnector;
import org.spaceon.apiendpoints.ApiFetchFactory;
import org.spaceon.apiendpoints.ProjectInfoEndPoint;
import org.spaceon.apiresponse.ProjectIdResponse;

import java.io.IOException;

public class ProjectInfoJson implements JsonResponseFactory {
    @Override
    public String jsonResponse() throws IOException {
        JsonResponseFactory jsonResponseFactory = new ProjectIdJson();
        ProjectIdResponse projectIdResponse = new ProjectIdResponse(jsonResponseFactory);
        projectIdResponse.response(jsonResponseFactory , new Gson());

        int id = projectIdResponse.getProjectIdData();
        System.out.println(id);
        ApiFetchFactory apiFetchFactory = new ProjectInfoEndPoint(id);
        ApiConnector apiConnector = new ApiConnector(apiFetchFactory);
        apiFetchFactory.endPoint(apiConnector);
        String response = apiConnector.getResponse();
        return response;
    }
}
