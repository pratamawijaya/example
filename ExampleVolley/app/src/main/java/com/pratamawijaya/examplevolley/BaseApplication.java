package com.pratamawijaya.examplevolley;

import android.app.Application;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by pratama on 2/25/15.
 */
public class BaseApplication extends Application {
    private RequestQueue requestQueue;
    private static BaseApplication instance;
    private static final int TIMEOUT_MS = 30000; // 30second

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /**
     * get instance application
     *
     * @return
     */
    public static synchronized BaseApplication getInstance() {
        return instance;
    }

    /**
     * get requestQueue from volley
     *
     * @return
     */
    public RequestQueue getRequestQueue() {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(instance);
        return requestQueue;
    }

    /**
     * Add request to queue using specific tag
     *
     * @param request
     * @param tag
     */
    public <T> void addToRequestQueue(Request<T> request, String tag) {
        // set retry policy
        Log.d("debug", request.getUrl());
        request.setRetryPolicy(new DefaultRetryPolicy(
                TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        getRequestQueue().add(request);
    }

    /**
     * cancelling all pending request by TAG
     *
     * @param tag
     */
    public void cancelPendingRequest(Object tag) {
        if (requestQueue != null)
            requestQueue.cancelAll(tag);
    }
}
