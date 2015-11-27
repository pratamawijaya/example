package com.pratamawijaya.blog;

import android.app.Application;
import com.pratamawijaya.blog.data.network.PratamaApiModule;
import com.pratamawijaya.blog.data.network.PratamaApiService;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
@Singleton @Component(modules = { AppModule.class, PratamaApiModule.class })
public interface AppComponent {
  Application getApplication();

  PratamaApiService getService();
}
