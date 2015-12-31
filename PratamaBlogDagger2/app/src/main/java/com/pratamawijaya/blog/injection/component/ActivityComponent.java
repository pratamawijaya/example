package com.pratamawijaya.blog.injection.component;

import android.content.Context;
import com.pratamawijaya.blog.injection.ActivityContext;
import com.pratamawijaya.blog.injection.PerActivity;
import com.pratamawijaya.blog.injection.module.ActivityModule;
import com.pratamawijaya.blog.ui.home.HomeViewActivity;
import dagger.Component;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
@PerActivity @Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  void inject(HomeViewActivity activity);
  @ActivityContext Context context();
}
