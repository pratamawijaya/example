package com.pratamawijaya.retrofit20.data;

import com.pratamawijaya.retrofit20.helper.LoggingInterceptor;
import com.squareup.okhttp.OkHttpClient;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/11/15
 * Project : Retrofit20
 */
public class RetrofitHelper {
  public static final String API_URL = "https://api.github.com/";

  /**
   * get service
   * <p>
   * Retrofit 2.0 mengalami perubahan terutama tidak lagi menggunakan gson secara default, jadi
   * untuk menggunakan Gson converter perlu menambahkan alamat repo di build.gradle dan menambahkan
   * addConverterFactory pada inisiasi Retrofit;
   * </p>
   *
   * <p>
   * OkHttp menjadi default httpclient, sebelumnya di versi 1.9.0 perlu menambahkan secara manual
   * </p>
   *
   * <p>
   * Agar bisa digunakan dengan RxAndroid perlu menambhakan adapter 'com.squareup.retrofit:adapter-rxjava:2.0.0-beta1'
   * </p>
   *
   * @return services API
   */
  public GithubService getService() {
    OkHttpClient httpClient = new OkHttpClient();
    httpClient.interceptors().add(new LoggingInterceptor());
    Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(httpClient)
        .build();
    return retrofit.create(GithubService.class);
  }
}
