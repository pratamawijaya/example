package com.pratamawijaya.blog.injection.component;

import com.pratamawijaya.blog.injection.module.VehicleModule;
import com.pratamawijaya.blog.model.Vehicle;
import com.pratamawijaya.blog.ui.MainActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
@Singleton @Component(modules = { VehicleModule.class }) public interface VehicleComponent {
  Vehicle provideVehicle();

  void inject(MainActivity activity);
}
