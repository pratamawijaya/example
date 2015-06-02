package com.gamatechno.exampleglidevspicasso;

import android.app.Application;

import com.squareup.picasso.Picasso;

/**
 * Created by pratama on 4/7/15.
 */
public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Picasso.with(this).setLoggingEnabled(true);
    }
}
