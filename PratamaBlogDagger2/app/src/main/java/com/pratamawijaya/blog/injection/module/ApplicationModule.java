package com.pratamawijaya.blog.injection.module;

import android.app.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pratamawijaya.blog.data.network.PratamaService;
import com.squareup.okhttp.OkHttpClient;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
@Module public class ApplicationModule {
  protected final Application application;

  public ApplicationModule(Application application) {
    this.application = application;
  }

  @Provides @Singleton static OkHttpClient providesOkHttpClient() {
    OkHttpClient okHttpClient = new OkHttpClient();
    return okHttpClient;
  }

  @Provides @Singleton static Gson providesGson() {
    Gson gson = new GsonBuilder().create();
    return gson;
  }

  @Provides @Singleton static PratamaService provideService(OkHttpClient okHttpClient, Gson gson) {
    return PratamaService.Creator.newPratamaService(okHttpClient, gson);
  }
}
