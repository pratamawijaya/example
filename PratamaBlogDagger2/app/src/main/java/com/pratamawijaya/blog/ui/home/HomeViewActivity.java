package com.pratamawijaya.blog.ui.home;

import android.os.Bundle;
import butterknife.ButterKnife;
import com.pratamawijaya.blog.R;
import com.pratamawijaya.blog.base.BaseActivity;

public class HomeViewActivity extends BaseActivity {

  private static final String TAG = "HomeViewActivity";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivityComponent().inject(this);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }
}
