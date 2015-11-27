package com.pratamawijaya.blog.presenter.inject;

import com.pratamawijaya.blog.AppComponent;
import com.pratamawijaya.blog.presenter.MainActivityPresenter;
import com.pratamawijaya.blog.ui.MainActivity;
import dagger.Component;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
@ActivityScope @Component(modules = PresenterModule.class, dependencies = AppComponent.class)
public interface PresenterComponent {
  MainActivity inject(MainActivity mainActivity);

  MainActivityPresenter getPresenter();
}
