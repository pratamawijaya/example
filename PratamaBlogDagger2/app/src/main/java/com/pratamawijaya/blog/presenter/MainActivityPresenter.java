package com.pratamawijaya.blog.presenter;

import com.pratamawijaya.blog.data.network.PratamaApiService;
import com.pratamawijaya.blog.ui.MainActivity;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
public class MainActivityPresenter {
  private MainActivity mainActivity;
  private PratamaApiService service;

  public MainActivityPresenter(MainActivity mainActivity, PratamaApiService service) {
    this.mainActivity = mainActivity;
    this.service = service;
  }

  public void apa() {
    service.getApa().subscribe();
  }
}
