package com.pratamawijaya.retrofit20.helper;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/12/15
 * Project : Retrofit20
 */
public class LoggingInterceptor implements Interceptor {
  @Override public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();

    long t1 = System.nanoTime();
    Timber.i(String.format("Sending request %s on %s%n%s", request.url(), chain.connection(),
        request.headers()));

    Response response = chain.proceed(request);

    long t2 = System.nanoTime();
    Timber.i(String.format("Received response for %s in %.1fms%n%s", response.request().url(),
        (t2 - t1) / 1e6d, response.headers()));

    Timber.i("response : " + response.message());

    return response;
  }
}
