package com.pratamawijaya.blog.ui;

import android.os.Bundle;
import android.util.Log;
import butterknife.ButterKnife;
import com.pratamawijaya.blog.R;
import com.pratamawijaya.blog.injection.component.AppComponent;
import com.pratamawijaya.blog.injection.module.PresenterModule;
import com.pratamawijaya.blog.model.Vehicle;
import com.pratamawijaya.blog.presenter.MainActivityPresenter;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  private static final String TAG = "MainActivity";
  @Inject MainActivityPresenter presenter;

  @Inject Vehicle vehicle;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    presenter.apa();

    Log.d(TAG, "onCreate: " + vehicle.getSpeed());
    vehicle.getSpeed();
  }

  @Override protected void setupAcitivityComponent(AppComponent appComponent) {
    DaggerPresenterComponent.builder()
        .appComponent(appComponent)
        .presenterModule(new PresenterModule(this))
        .build()
        .inject(this);


    DaggerVehicleComponent.builder().build().inject(this);
  }
}
