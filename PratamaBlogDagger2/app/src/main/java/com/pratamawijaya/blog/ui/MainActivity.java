package com.pratamawijaya.blog.ui;

import android.os.Bundle;
import butterknife.ButterKnife;
import com.pratamawijaya.blog.AppComponent;
import com.pratamawijaya.blog.R;
import com.pratamawijaya.blog.presenter.MainActivityPresenter;
import com.pratamawijaya.blog.presenter.inject.DaggerPresenterComponent;
import com.pratamawijaya.blog.presenter.inject.PresenterModule;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  @Inject MainActivityPresenter presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    presenter.apa();
  }

  @Override protected void setupAcitivityComponent(AppComponent appComponent) {
    DaggerPresenterComponent.builder()
        .appComponent(appComponent)
        .presenterModule(new PresenterModule(this))
        .build()
        .inject(this);
  }
}
