package id.pratama.example.parse;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import id.pratama.example.parse.entity.Book;
import id.pratama.example.parse.entity.Toko;

/**
 * Created by pratama on 4/21/14.
 */
public class BaseApplication extends Application {
    private final String APP_ID = "rz4I2225gps7YArzWwookloVDis8d5hfgIi41Xiu";
    private final String CLIENT_KEY = "zqQ9heqddRgYBOJS37tvC6LUtyD0nYrzNDeNKNME";

    @Override
    public void onCreate() {
        super.onCreate();

        // register class
        ParseObject.registerSubclass(Book.class);
        ParseObject.registerSubclass(Toko.class);


        // initialize parse
        Parse.initialize(this, APP_ID, CLIENT_KEY);

    }
}
