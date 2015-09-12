package com.pratamawijaya.bbmmaterial.view.home;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.bbmmaterial.R;

public class HomeViewCodeLabsActivity extends AppCompatActivity {

  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.tabLayout) TabLayout tabLayout;
  @Bind(R.id.viewPager) ViewPager viewPager;
  @Bind(R.id.btnFab) FloatingActionButton btnFab;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home_view_code_labs);
    ButterKnife.bind(this);

    setupActionBar();
  }

  private void setupActionBar() {
    setSupportActionBar(toolbar);
    setupTabLayout();
  }

  private void setupTabLayout() {

  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_home_view_code_labs, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
