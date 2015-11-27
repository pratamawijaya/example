package com.pratamawijaya.blog.data.network;

import android.app.Application;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
@Module
public class PratamaApiModule {

  private static final String API_URL = "https://api.github.com";

  @Provides @Singleton Cache provideOkttpCache(Application application) {
    int cacheSize = 10 * 1024 * 1024;
    Cache cache = new Cache(application.getCacheDir(), cacheSize);
    return cache;
  }

  @Provides @Singleton Gson providesGson() {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    return gsonBuilder.create();
  }

  @Provides @Singleton OkHttpClient provideOkHttpClient(Cache cache) {
    OkHttpClient client = new OkHttpClient();
    client.setCache(cache);
    return client;
  }

  @Provides @Singleton Retrofit provideRetrofit(Application application, Gson gson,
      OkHttpClient okHttpClient) {
    Retrofit.Builder retrofit = new Retrofit.Builder().baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(okHttpClient);
    return retrofit.build();
  }

  @Provides @Singleton PratamaApiService providePratamaService(Retrofit retrofit) {
    return retrofit.create(PratamaApiService.class);
  }
}
