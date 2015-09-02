package com.pratamawijaya.mosbyexample.base;

import android.app.Application;
import com.pratamawijaya.mosbyexample.BuildConfig;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/2/15
 * Project : MosbyExample
 */
public class BaseApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
  }
}
