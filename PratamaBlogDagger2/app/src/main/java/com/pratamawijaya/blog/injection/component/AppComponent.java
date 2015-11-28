package com.pratamawijaya.blog.injection.component;

import android.app.Application;
import com.pratamawijaya.blog.data.network.PratamaApiModule;
import com.pratamawijaya.blog.data.network.PratamaApiService;
import com.pratamawijaya.blog.injection.module.AppModule;
import com.pratamawijaya.blog.injection.module.VehicleModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
@Singleton @Component(modules = { AppModule.class, PratamaApiModule.class, VehicleModule.class })
public interface AppComponent {
  Application getApplication();

  PratamaApiService getService();
}
