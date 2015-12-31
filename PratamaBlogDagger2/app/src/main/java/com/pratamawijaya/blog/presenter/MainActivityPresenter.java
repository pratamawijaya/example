package com.pratamawijaya.blog.presenter;

import com.pratamawijaya.blog.data.network.PratamaService;
import com.pratamawijaya.blog.ui.MainActivity;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
public class MainActivityPresenter {
  private MainActivity mainActivity;
  private PratamaService service;

  public MainActivityPresenter(MainActivity mainActivity, PratamaService service) {
    this.mainActivity = mainActivity;
    this.service = service;
  }

  public void apa() {
    service.getApa().subscribe();
  }
}
