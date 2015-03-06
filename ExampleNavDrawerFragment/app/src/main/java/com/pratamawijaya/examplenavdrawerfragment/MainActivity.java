package com.pratamawijaya.examplenavdrawerfragment;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.pratamawijaya.examplenavdrawerfragment.activity.ActivityFragment;
import com.pratamawijaya.examplenavdrawerfragment.home.HomeFragment;
import com.pratamawijaya.examplenavdrawerfragment.navdrawer.FragmentNavigationDrawer;


public class MainActivity extends ActionBarActivity {

    private FragmentNavigationDrawer fragmentNavigationDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentNavigationDrawer = (FragmentNavigationDrawer) findViewById(R.id.drawerLayout);

        fragmentNavigationDrawer.setupDrawerConfiguration((ListView) findViewById(R.id.lvDrawer), toolbar, R.layout.drawer_nav_item, R.id.containerContent);

        fragmentNavigationDrawer.addNavItem("Home", "Home Fragment", HomeFragment.class);
        fragmentNavigationDrawer.addNavItem("Activity", "Activity Fragment", ActivityFragment.class);

        if (savedInstanceState == null)
            fragmentNavigationDrawer.selectDrawerItem(0);

    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (fragmentNavigationDrawer.isDrawerOpen()) {

        }

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (fragmentNavigationDrawer.getDrawerToggle().onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        fragmentNavigationDrawer.getDrawerToggle().syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        fragmentNavigationDrawer.getDrawerToggle().onConfigurationChanged(newConfig);
    }
}
