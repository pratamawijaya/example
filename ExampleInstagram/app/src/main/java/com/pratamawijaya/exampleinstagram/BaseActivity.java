package com.pratamawijaya.exampleinstagram;

import android.support.v7.app.ActionBarActivity;
import android.widget.Toolbar;

/**
 * Created by pratama on 12/12/14.
 */
public class BaseActivity extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        getActionBarToolbar();
    }

    protected Toolbar getActionBarToolbar() {
        if (toolbar != null) {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setActionBar(toolbar);
        }
        return toolbar;
    }
}
