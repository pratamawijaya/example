package com.pratamawijaya.mosbyexample.presenter;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.pratamawijaya.mosbyexample.view.HomeView;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/2/15
 * Project : MosbyExample
 */
public interface HomeViewPresenterInterfaces extends MvpPresenter<HomeView> {
    void loadArticle(final boolean pullToRefresh);
}
