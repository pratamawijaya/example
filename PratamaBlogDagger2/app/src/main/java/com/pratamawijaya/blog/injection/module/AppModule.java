package com.pratamawijaya.blog.injection.module;

import android.app.Application;
import com.pratamawijaya.blog.App;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */

@Module
public class AppModule {
  private App app;

  public AppModule(App app) {
    this.app = app;
  }

  @Provides
  @Singleton
  public Application provideApplication(){
    return app;
  }
}