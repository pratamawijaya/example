package me.pratama.examplematerial;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

/**
 * Created by pratama on 12/14/14.
 */
public class BaseActivity extends ActionBarActivity {

    private Toolbar toolbar;


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        getToolbar();
    }

    /**
     * get toolbar
     *
     * @return
     */
    protected Toolbar getToolbar() {
        if (toolbar == null) {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            Log.d("test", "setSupport");
        }
        return toolbar;
    }
}
