package com.pratamawijaya.blog.injection.module;

import android.app.Activity;
import android.content.Context;
import com.pratamawijaya.blog.injection.ActivityContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
@Module public class ActivityModule {

  private Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  @Provides Activity provideActivity() {
    return activity;
  }

  @Provides @ActivityContext Context provideContext() {
    return activity;
  }
}
