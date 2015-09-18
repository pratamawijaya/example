package com.pratamawijaya.retrofit20;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.pratamawijaya.retrofit20.data.RetrofitHelper;
import com.pratamawijaya.retrofit20.model.Contributor;
import java.util.List;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class MainActivity extends AppCompatActivity {

  private RetrofitHelper api;
  private ProgressDialog progressDialog;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    progressDialog = new ProgressDialog(this);
    progressDialog.setMessage("Loading...");

    api = new RetrofitHelper();

    //Observable<List<Contributor>> observable = api.getService().contributors("square", "retrofit");
    //
    //observable.observeOn(AndroidSchedulers.mainThread())
    //    .subscribe(new Subscriber<List<Contributor>>() {
    //      @Override public void onCompleted() {
    //
    //      }
    //
    //      @Override public void onError(Throwable e) {
    //
    //      }
    //
    //      @Override public void onNext(List<Contributor> contributors) {
    //        for (Contributor data : contributors)
    //          Timber.d("data :" + data.getLogin());
    //      }
    //    });

    //api.getService()
    //    .contributors("square", "retrofit")
    //    .subscribeOn(Schedulers.newThread())
    //    .observeOn(AndroidSchedulers.mainThread())
    //    .subscribe(new Observer<List<Contributor>>() {
    //      @Override public void onCompleted() {
    //        progressDialog.dismiss();
    //      }
    //
    //      @Override public void onError(Throwable e) {
    //        Timber.e("error : " + e.toString());
    //      }
    //
    //      @Override public void onNext(List<Contributor> contributors) {
    //        for (Contributor data : contributors)
    //          Log.d("data", "" + data.getLogin());
    //      }
    //    });

    Call<List<Contributor>> call = api.getService().contributors("square", "retrofit");

    progressDialog.show();
    call.enqueue(new Callback<List<Contributor>>() {
      @Override public void onResponse(Response<List<Contributor>> response) {
        progressDialog.dismiss();
        for (Contributor data : response.body())
          Log.d("data", "" + data.getLogin());
      }

      @Override public void onFailure(Throwable t) {
        progressDialog.dismiss();
      }
    });

    call.cancel();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
