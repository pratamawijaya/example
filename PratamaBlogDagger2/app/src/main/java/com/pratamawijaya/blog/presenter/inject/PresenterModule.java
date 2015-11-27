package com.pratamawijaya.blog.presenter.inject;

import com.pratamawijaya.blog.data.network.PratamaApiService;
import com.pratamawijaya.blog.presenter.MainActivityPresenter;
import com.pratamawijaya.blog.ui.MainActivity;
import dagger.Module;
import dagger.Provides;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */

@Module public class PresenterModule {
  private MainActivity mainActivity;

  public PresenterModule(MainActivity mainActivity) {
    this.mainActivity = mainActivity;
  }

  @Provides @ActivityScope MainActivity provideMainActivity() {
    return mainActivity;
  }

  @Provides @ActivityScope MainActivityPresenter provideMainActivityPresenter(
      MainActivity mainActivity, PratamaApiService service) {
    return new MainActivityPresenter(mainActivity, service);
  }
}
