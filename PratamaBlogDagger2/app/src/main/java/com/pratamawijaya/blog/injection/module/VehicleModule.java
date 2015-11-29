package com.pratamawijaya.blog.injection.module;

import com.pratamawijaya.blog.model.Motor;
import com.pratamawijaya.blog.model.Vehicle;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
@Module public class VehicleModule {

  @Provides @Singleton Motor provideMotor() {
    return new Motor();
  }

  @Provides @Singleton Vehicle provideVehicle() {
    return new Vehicle(new Motor());
  }
}
