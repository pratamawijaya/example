package com.pratamawijaya.blog;

import android.app.Application;
import android.content.Context;
import com.pratamawijaya.blog.data.network.PratamaApiModule;
import com.pratamawijaya.blog.injection.component.AppComponent;
import com.pratamawijaya.blog.injection.component.DaggerAppComponent;
import com.pratamawijaya.blog.injection.module.AppModule;
import com.pratamawijaya.blog.injection.module.VehicleModule;

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
        .vehicleModule(new VehicleModule())
        .build();
  }

  public static App get(Context context) {
    return (App) context.getApplicationContext();
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }
}
