package com.pratamawijaya.blog.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import com.pratamawijaya.blog.App;
import com.pratamawijaya.blog.AppComponent;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
public abstract class BaseActivity extends AppCompatActivity {
  @Override public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
    setupAcitivityComponent(App.get(this).getAppComponent());
  }

  protected abstract void setupAcitivityComponent(AppComponent appComponent);
}
