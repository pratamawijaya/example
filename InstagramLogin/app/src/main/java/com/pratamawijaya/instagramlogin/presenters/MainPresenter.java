package com.pratamawijaya.instagramlogin.presenters;

import android.content.Context;
import com.pratamawijaya.instagramlogin.models.ResponseToken;
import com.pratamawijaya.instagramlogin.network.InstagramService;
import com.pratamawijaya.instagramlogin.utils.PreferencesUtils;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/17/15
 * Project : InstagramLogin
 */
public class MainPresenter {
  private Context context;
  private InstagramService api;

  public MainPresenter(Context context) {
    this.context = context;
    api = new InstagramService();
  }

  public void getToken(String clientID, String clientSecret, String redirectUri, String code) {
    api.getApi()
        .getToken(clientID, clientSecret, "authorization_code", redirectUri, code)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<ResponseToken>() {
          @Override public void onCompleted() {
            Timber.i("completed");
          }

          @Override public void onError(Throwable e) {
            Timber.e("error : " + e.getMessage());
          }

          @Override public void onNext(ResponseToken responseToken) {
            Timber.i("response : " + responseToken.getToken());
            PreferencesUtils.setDataStringToSP(context, PreferencesUtils.INSTAGRAM_TOKEN,
                responseToken.getToken());

            PreferencesUtils.setDataStringToSP(context, PreferencesUtils.USER_ID,
                responseToken.getUser().getId());

          }
        });
  }


}
