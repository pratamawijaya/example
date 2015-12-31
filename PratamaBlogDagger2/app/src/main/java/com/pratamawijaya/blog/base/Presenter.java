package com.pratamawijaya.blog.base;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public interface Presenter<V extends MvpView> {

  void attachView(V mvpView);

  void detachView();
}
