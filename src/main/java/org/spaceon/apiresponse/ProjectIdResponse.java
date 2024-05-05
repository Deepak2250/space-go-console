package org.spaceon.apiresponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.spaceon.apijson.JsonResponseFactory;
import org.spaceon.gsonObjet.GsonFactoryData;

import java.io.IOException;

public class ProjectIdResponse implements GsonFactoryData {

    private int projectIdData;
    private JsonResponseFactory jsonResponseFactory;

    public ProjectIdResponse(JsonResponseFactory jsonResponseFactory) {
        this.jsonResponseFactory = jsonResponseFactory;
    }

    @Override
    public void response(JsonResponseFactory responseFactory, Gson gson) throws IOException {
        String projectIdJsonResponse = jsonResponseFactory.jsonResponse();
        JsonObject gsonResponse = gson.fromJson(projectIdJsonResponse, JsonObject.class);

        JsonArray projectArray = gsonResponse.getAsJsonArray("projects");
        int randomIndex = (int) (Math.floor(Math.random() * projectArray.size()));

        JsonObject projetObject = projectArray.get(randomIndex).getAsJsonObject();
        int projectResponse = projetObject.get("projectId").getAsInt();
        projectIdData = projectResponse;

    }

    public int getProjectIdData() {
        return projectIdData;
    }
}
