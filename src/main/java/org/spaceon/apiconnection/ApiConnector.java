package org.spaceon.apiconnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.spaceon.apiendpoints.ApiFetchFactory;

import java.io.IOException;

public class ApiConnector {

    private String apiresponse;
    private final OkHttpClient okHttpClient;
    private  ApiFetchFactory apiFetchFactory;

    public ApiConnector(ApiFetchFactory apiFetchFactory){
        this.okHttpClient = new OkHttpClient();
        this.apiFetchFactory = apiFetchFactory;
    }

    public ApiConnector(){
        this.okHttpClient = new OkHttpClient();
    }

    public String fetchApi(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            System.out.println("It Passed The Api Connector");
            apiresponse = response.body().string();
            return apiresponse;
        }
    }

    public String getResponse(){
        return apiresponse;
    }

}
