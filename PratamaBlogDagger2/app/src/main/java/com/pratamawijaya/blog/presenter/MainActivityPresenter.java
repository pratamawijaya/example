package com.pratamawijaya.blog.presenter;

import com.pratamawijaya.blog.data.network.PratamaService;
import com.pratamawijaya.blog.ui.home.HomeViewActivity;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
public class MainActivityPresenter {
  private HomeViewActivity homeViewActivity;
  private PratamaService service;

  public MainActivityPresenter(HomeViewActivity homeViewActivity, PratamaService service) {
    this.homeViewActivity = homeViewActivity;
    this.service = service;
  }

  public void apa() {
    service.getApa().subscribe();
  }
}
