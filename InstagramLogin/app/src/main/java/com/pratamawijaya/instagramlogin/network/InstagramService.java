package com.pratamawijaya.instagramlogin.network;

import com.google.gson.Gson;
import com.pratamawijaya.instagramlogin.BuildConfig;
import com.squareup.okhttp.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/17/15
 * Project : InstagramLogin
 */
public class InstagramService {
  private final String URL = "https://api.instagram.com";
  private final InstagramApi api;

  public InstagramService() {
    OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();

    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(URL)
        .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
        .setClient(new OkClient(client))
        .setConverter(new GsonConverter(gson))
        .build();

    api = restAdapter.create(InstagramApi.class);
  }

  public InstagramApi getApi() {
    return api;
  }
}
