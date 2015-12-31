package com.pratamawijaya.blog.base;

import android.support.v7.app.AppCompatActivity;
import com.pratamawijaya.blog.App;
import com.pratamawijaya.blog.injection.component.ActivityComponent;
import com.pratamawijaya.blog.injection.component.DaggerActivityComponent;
import com.pratamawijaya.blog.injection.module.ActivityModule;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public class BaseActivity extends AppCompatActivity {
  private ActivityComponent activityComponent;

  public ActivityComponent getActivityComponent() {
    if (activityComponent == null) {
      activityComponent = DaggerActivityComponent.builder()
          .activityModule(new ActivityModule(this))
          .applicationComponent(App.get(this).getApplicationComponent())
          .build();
    }
    return activityComponent;
  }
}
