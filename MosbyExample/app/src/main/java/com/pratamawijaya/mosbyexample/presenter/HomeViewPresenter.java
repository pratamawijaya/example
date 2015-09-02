package com.pratamawijaya.mosbyexample.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.pratamawijaya.mosbyexample.data.NetworkAPI;
import com.pratamawijaya.mosbyexample.model.response.ResponsePost;
import com.pratamawijaya.mosbyexample.view.HomeView;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/2/15
 * Project : MosbyExample
 */
public class HomeViewPresenter extends MvpBasePresenter<HomeView>
    implements HomeViewPresenterInterfaces {

  private NetworkAPI api;

  public HomeViewPresenter() {
    api = new NetworkAPI();
  }

  @Override public void detachView(boolean retainInstance) {
    super.detachView(retainInstance);
  }

  @Override public void loadArticle(final boolean pullToRefresh) {
    Timber.d("load article : " + pullToRefresh);
    Timber.d("show loading " + pullToRefresh);

    getView().showLoading(pullToRefresh);

    api.getService().getPosts()// call api
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<ResponsePost>() {
          @Override public void onCompleted() {
            // hide loader
          }

          @Override public void onError(Throwable e) {
            getView().showError(e, pullToRefresh);
          }

          @Override public void onNext(ResponsePost responsePost) {
            if (isViewAttached()) {
              getView().setData(responsePost.getPosts());
              getView().showContent();
            }
          }
        });
  }
}
