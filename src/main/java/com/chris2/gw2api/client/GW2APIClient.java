package com.chris2.gw2api.client;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by napal on 4/11/2017.
 */
public class GW2APIClient {

    private final static OkHttpClient CLIENT = new OkHttpClient();

    public static OkHttpClient getClient() {
        return CLIENT;
    }

    public static Response executeRequest(Request request) throws IOException {
        return GW2APIClient.getClient().newCall(request).execute();
    }

}
