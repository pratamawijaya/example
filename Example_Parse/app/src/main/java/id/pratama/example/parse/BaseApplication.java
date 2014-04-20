package id.pratama.example.parse;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import id.pratama.example.parse.entity.Book;

/**
 * Created by pratama on 4/21/14.
 */
public class BaseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        // register class
        ParseObject.registerSubclass(Book.class);

        // initialize parse
        Parse.initialize(this,"appID","clientKey");

    }
}
