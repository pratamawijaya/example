package com.pratamawijaya.blog;

import android.app.Application;
import android.content.Context;
import com.pratamawijaya.blog.data.network.PratamaApiModule;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
public class App extends Application {
  private AppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();

    appComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .pratamaApiModule(new PratamaApiModule())
        .build();
  }

  public static App get(Context context){
    return (App) context.getApplicationContext();
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }
}
