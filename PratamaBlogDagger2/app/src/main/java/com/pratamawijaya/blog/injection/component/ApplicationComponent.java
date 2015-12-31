package com.pratamawijaya.blog.injection.component;

import android.app.Application;
import android.content.Context;
import com.pratamawijaya.blog.data.DataManager;
import com.pratamawijaya.blog.data.network.PratamaService;
import com.pratamawijaya.blog.injection.ApplicationContext;
import com.pratamawijaya.blog.injection.module.ApplicationModule;
import dagger.Component;
import io.realm.Realm;
import javax.inject.Singleton;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
@Singleton @Component(modules = ApplicationModule.class) public interface ApplicationComponent {

  @ApplicationContext Context context();

  Application application();

  PratamaService pratamaService();

  DataManager dataManager();

  Realm realm();
}
