package com.pratamawijaya.retrofit20;

import android.app.Application;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/12/15
 * Project : Retrofit20
 */
public class BaseApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
  }
}
