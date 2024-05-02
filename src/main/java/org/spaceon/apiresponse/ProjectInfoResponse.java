package org.spaceon.apiresponse;

import com.google.gson.Gson;
import org.spaceon.apiendpoints.ProjectInfoEndPoint;
import org.spaceon.apijson.JsonResponseFactory;
import org.spaceon.apijson.ProjectInfoJson;
import org.spaceon.gsonObjet.GsonFactoryData;

import java.io.IOException;

public class ProjectInfoResponse implements GsonFactoryData {

    private JsonResponseFactory jsonResponseFactory;
    private ProjectIdResponse projectIdResponse;
    private ProjectInfoEndPoint projectInfoEndPoint;
    public ProjectInfoResponse(JsonResponseFactory jsonResponseFactory){
        this.jsonResponseFactory = jsonResponseFactory;
        this.projectInfoEndPoint = new ProjectInfoEndPoint();
        this.projectIdResponse = new ProjectIdResponse(jsonResponseFactory);
    }
    @Override
    public void response(JsonResponseFactory responseFactory, Gson gson) throws IOException {

        int id = projectIdResponse.getProjectIdData();
        projectInfoEndPoint.setId(id);

    }
}
