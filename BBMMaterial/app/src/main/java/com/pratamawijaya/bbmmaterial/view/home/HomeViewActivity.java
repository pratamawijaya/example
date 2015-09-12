package com.pratamawijaya.bbmmaterial.view.home;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.bbmmaterial.R;
import com.pratamawijaya.bbmmaterial.model.FragmentHomeItem;
import com.pratamawijaya.bbmmaterial.presenter.HomeViewPresenter;
import com.pratamawijaya.bbmmaterial.view.home.adapter.HomeFragmentAdapter;
import java.util.List;

public class HomeViewActivity extends AppCompatActivity
    implements HomeViewInterface, NavigationView.OnNavigationItemSelectedListener {

  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.drawerLayout) DrawerLayout drawerLayout;
  @Bind(R.id.navigationView) NavigationView navigationView;
  @Bind(R.id.tabLayout) TabLayout tabLayout;
  @Bind(R.id.viewPager) ViewPager viewPager;

  private HomeViewPresenter presenter;

  private HomeFragmentAdapter fragmentAdapter;
  private ActionBar actionBar;
  private ImageView userPicture;
  private TextView userName, userStatus;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    setupActionBar();
    setupNavigationView();

    presenter = new HomeViewPresenter(this);
    presenter.initPresenter();
    presenter.loadDataUser(this, userPicture, userName, userStatus);
  }

  private void setupNavigationView() {
    if (navigationView != null) {
      View header = navigationView.inflateHeaderView(R.layout.layout_header_navdrawer);
      userPicture = (ImageView) header.findViewById(R.id.userPicture);
      userName = (TextView) header.findViewById(R.id.userName);
      userStatus = (TextView) header.findViewById(R.id.userStatus);
    }
  }

  private void setupActionBar() {
    setSupportActionBar(toolbar);
    actionBar = getSupportActionBar();
    actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
    actionBar.setDisplayHomeAsUpEnabled(true);
  }

  private void setupTabLayout(ViewPager viewPager) {
    tabLayout.setTabMode(TabLayout.MODE_FIXED);
    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    tabLayout.setupWithViewPager(viewPager);
    for (int i = 0; i < tabLayout.getTabCount(); i++) {
      TabLayout.Tab tab = tabLayout.getTabAt(i);
      tab.setCustomView(fragmentAdapter.getTabView(i));
    }
    tabLayout.requestFocus();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.

    switch (item.getItemId()) {
      case android.R.id.home:
        drawerLayout.openDrawer(GravityCompat.START);
        break;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override public void setupViewPager(List<FragmentHomeItem> fragmentHomeItems) {
    fragmentAdapter = new HomeFragmentAdapter(this, getSupportFragmentManager(), fragmentHomeItems);
    viewPager.setAdapter(fragmentAdapter);
    setupTabLayout(viewPager);
  }

  @Override public boolean onNavigationItemSelected(MenuItem menuItem) {
    return false;
  }
}
