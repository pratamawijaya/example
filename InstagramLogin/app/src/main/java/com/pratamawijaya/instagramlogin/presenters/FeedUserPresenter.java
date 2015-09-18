package com.pratamawijaya.instagramlogin.presenters;

import android.content.Context;
import com.pratamawijaya.instagramlogin.network.InstagramService;
import com.pratamawijaya.instagramlogin.views.feed.FeedUserInterface;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/18/15
 * Project : InstagramLogin
 */
public class FeedUserPresenter {
  private Context context;
  private InstagramService api;
  private FeedUserInterface view;

  public FeedUserPresenter(Context context, FeedUserInterface view) {
    this.context = context;
    this.view = view;
    api = new InstagramService();
  }

  public void getUserMedia(String userID, String accessToken) {
    view.showLoading();
    api.getApi()
        .getUserMediaRecent(userID, accessToken)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(userMediaResponse -> {
          view.hideLoading();

          view.showData(userMediaResponse.getData());

          //for (Post data : userMediaResponse.getData()) {
          //  Timber.d("" + data.getImages().getStandardResolution().getUrl());
          //}

        }, throwable -> {
          Timber.e("error " + throwable.toString());
          view.hideLoading();
        }, () -> {
          Timber.i("completed");
          view.hideLoading();
        });
  }
}
