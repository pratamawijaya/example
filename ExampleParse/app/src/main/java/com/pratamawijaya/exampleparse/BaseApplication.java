package com.pratamawijaya.exampleparse;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by pratama on 9/2/14.
 */
public class BaseApplication extends Application {

    private static final String APP_ID = "yoYocvh3qZQKJAlZ6FwQLxirdV4N4sY8NSwjkqHd";
    private static final String CLIENT_ID = "rhVtRDpYgJpgd2kgZmNIWJNfWqbKN56PaX0mHM90";

    @Override
    public void onCreate() {
        super.onCreate();

        // initialize Parse
        Parse.initialize(this, APP_ID, CLIENT_ID);

        // enable local storage
        Parse.enableLocalDatastore(this);
    }
}
