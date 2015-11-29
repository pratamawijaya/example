package com.pratamawijaya.blog.data.network;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
public interface PratamaApiService {
  @GET("me/") Observable<String> getApa();
}
