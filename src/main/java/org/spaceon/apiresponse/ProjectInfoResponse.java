package org.spaceon.apiresponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.spaceon.apiendpoints.ProjectInfoEndPoint;
import org.spaceon.apijson.JsonResponseFactory;
import org.spaceon.apijson.ProjectIdJson;
import org.spaceon.apijson.ProjectInfoJson;
import org.spaceon.gsonObjet.GsonFactoryData;

import java.io.IOException;

public class ProjectInfoResponse implements GsonFactoryData {

    public ProjectInfoResponse() {
    }

    @Override
    public void response(JsonResponseFactory responseFactory, Gson gson) throws IOException {
        String title = null;
        String startDate = null;
        String endDate = null;
        String description = null;
        String projectManagers = null;
        String organizationType = null;
        String status = null;
        String stateContribute = null;


        String projectInfoResponse = responseFactory.jsonResponse();
        JsonObject jsonObject = gson.fromJson(projectInfoResponse, JsonObject.class);

        // Checking For the Title
        if (jsonObject.has("project") && jsonObject.getAsJsonObject("project").has("title")) {
            title = jsonObject.getAsJsonObject("project").get("title").getAsString();
        } else {
            System.out.println("No Title Available");
        }

        // Checking For the Starting Year
        if (jsonObject.has("project") && jsonObject.getAsJsonObject("project").has("startYear")) {
            startDate = jsonObject.getAsJsonObject("project").get("startYear").getAsString();
        } else {
            System.out.println("No start Date Available");
        }

        // Checking For the EndDate
        if (jsonObject.has("project") && jsonObject.getAsJsonObject("project").has("endYear")) {
            endDate = jsonObject.getAsJsonObject("project").get("endYear").getAsString();
        } else {
            System.out.println("No end Date Available");
        }

        // Checking For Description
        if (jsonObject.has("project") && jsonObject.getAsJsonObject("project").has("description")) {
            description = jsonObject.getAsJsonObject("project").get("description").getAsString();
        } else {
            System.out.println("No Description Available");
        }

        JsonArray projectManagersArray = jsonObject.getAsJsonObject("project").getAsJsonArray("projectManagers");
        if (projectManagersArray != null && projectManagersArray.size() > 0) {
            JsonObject projectManager = projectManagersArray.get(0).getAsJsonObject();
            String firstName = projectManager.get("firstName").getAsString();
            String lastName = projectManager.get("lastName").getAsString();
            String fullName = projectManager.get("fullName").getAsString();
            projectManagers = fullName;
        } else {
            System.out.println("No Project Managers Available");
        }

        // Checking For State Contribution
        JsonArray statesWithWorkArray = jsonObject.getAsJsonObject("project").getAsJsonArray("statesWithWork");
        if (statesWithWorkArray != null && statesWithWorkArray.size() > 0) {
            stateContribute = statesWithWorkArray.get(0).getAsJsonObject().get("name").getAsString();
        } else {
            System.out.println("No State Contributions Available");
        }

        // Checking For Lead Organization
        JsonObject leadOrganizationObject = jsonObject.getAsJsonObject("project").getAsJsonObject("leadOrganization");
        if (leadOrganizationObject != null && leadOrganizationObject.has("organizationType")) {
            organizationType = leadOrganizationObject.get("organizationType").getAsString();
        } else {
            System.out.println("No Organization Type Available");
        }

        // Checking For Status
        if (jsonObject.has("project") && jsonObject.getAsJsonObject("project").has("statusDescription")) {
            status = jsonObject.getAsJsonObject("project").get("statusDescription").getAsString();
        } else {
            System.out.println("No Status Description Available");
        }

        System.out.println(title + " From " + startDate + " to " + endDate);
        System.out.println();
        System.out.println(description);
        System.out.println();
        System.out.println("Contributors " + projectManagers);
        System.out.println();
        System.out.println("Led By " + organizationType);
        System.out.println();
        System.out.println("It's a " + status);
        System.out.println();
        System.out.println("State Contributes " + stateContribute);
    }

}
