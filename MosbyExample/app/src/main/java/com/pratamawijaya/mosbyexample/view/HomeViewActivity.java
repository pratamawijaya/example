package com.pratamawijaya.mosbyexample.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.Bind;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.ParcelableLceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.CastedArrayListLceViewState;
import com.pratamawijaya.mosbyexample.R;
import com.pratamawijaya.mosbyexample.model.Post;
import com.pratamawijaya.mosbyexample.presenter.HomeViewPresenter;
import com.pratamawijaya.mosbyexample.presenter.HomeViewPresenterInterfaces;
import java.util.List;

public class HomeViewActivity extends
    MvpLceViewStateActivity<SwipeRefreshLayout, List<Post>, HomeView, HomeViewPresenterInterfaces>
    implements HomeView, SwipeRefreshLayout.OnRefreshListener {

  @Bind(R.id.recyclerView) RecyclerView recyclerView;
  HomeAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // set contentview
    contentView.setOnRefreshListener(this);

    adapter = new HomeAdapter(this);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(adapter);
  }

  @NonNull @Override public HomeViewPresenterInterfaces createPresenter() {
    return new HomeViewPresenter();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    //getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override protected String getErrorMessage(Throwable throwable, boolean b) {
    return null;
  }

  @Override public void setData(List<Post> data) {
    adapter.setPosts(data);
    adapter.notifyDataSetChanged();
  }

  @Override public List<Post> getData() {
    return adapter == null ? null : adapter.getPosts();
  }

  @Override public void loadData(boolean pullToRefresh) {
    presenter.loadArticle(pullToRefresh);
  }

  @Override public ParcelableLceViewState<List<Post>, HomeView> createViewState() {
    return new CastedArrayListLceViewState<>();
  }

  @Override public void onRefresh() {
    loadData(true);
  }

  @Override public void showContent() {
    super.showContent();
    contentView.setRefreshing(false);
  }

  @Override public void showError(Throwable e, boolean pullToRefresh) {
    super.showError(e, pullToRefresh);
    contentView.setRefreshing(false);
  }

  @Override public void showLoading(boolean pullToRefresh) {
    super.showLoading(pullToRefresh);
    if (pullToRefresh && !contentView.isRefreshing()) {
      contentView.post(new Runnable() {
        @Override public void run() {
          contentView.setRefreshing(true);
        }
      });
    }
  }
}
