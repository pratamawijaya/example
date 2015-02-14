package com.pratamawijaya.examplerxjava.network;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.pratamawijaya.examplerxjava.model.Gist;
import com.pratamawijaya.examplerxjava.model.GistDetail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

/**
 * Created by pratama on 12/18/14.
 */
public class GithubNetworkService extends Service {

    /**
     * The GitHub REST API Endpoint
     */
    public final static String GITHUB_BASE_URL = "https://api.github.com";

    /**
     * Set this variable to your GitHub personal access token
     */
    public final static String GITHUB_PERSONAL_ACCESS_TOKEN = "";

    private GithubClient mGithubClient;
    private IBinder mBinder = new GithubBinder();
    private GithubCallback mCallback;


    public interface GithubClient {
        @GET("/gists")
        Observable<List<Gist>> gists();

        @GET("/gists/{id}")
        Observable<GistDetail> gist(@Path("id") String id);
    }

    public interface GithubCallback {
        void diplasyFiles(final List<GistDetail> gistDetailList);
    }

    public class GithubBinder extends Binder {
        public GithubNetworkService getService() {
            return GithubNetworkService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mGithubClient == null) {
            mGithubClient = new RestAdapter.Builder()
                    .setRequestInterceptor(new RequestInterceptor() {
                        @Override
                        public void intercept(RequestFacade request) {
                            request.addHeader("Authorization", "token " + GITHUB_PERSONAL_ACCESS_TOKEN);
                        }
                    })
                    .setEndpoint(GITHUB_BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.HEADERS)
                    .build()
                    .create(GithubClient.class);
        }
    }

    public void setmCallback(GithubCallback mCallback) {
        this.mCallback = mCallback;
    }

    public void getGist() {
        mGithubClient.gists()
                .flatMap(new Func1<List<Gist>, Observable<Gist>>() {
                    @Override
                    public Observable<Gist> call(List<Gist> gists) {
                        return Observable.from(gists);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .take(2)
                .cache()
                .groupBy(new Func1<Gist, String>() {
                    @Override
                    public String call(Gist gist) {
                        return gist.getId();
                    }
                })
                .flatMap(new Func1<GroupedObservable<String, Gist>, Observable<GistDetail>>() {
                    @Override
                    public Observable<GistDetail> call(GroupedObservable<String, Gist> stringGistGroupedObservable) {
                        return mGithubClient.gist(stringGistGroupedObservable.getKey());
                    }
                })
                .timeout(5000, TimeUnit.MILLISECONDS)
                .retry(1)
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<GistDetail>>() {
                               @Override
                               public void call(List<GistDetail> gistDetailList) {
                                   mCallback.diplasyFiles(gistDetailList);
                               }
                           }, new Action1<Throwable>() {
                               @Override
                               public void call(Throwable throwable) {
                                   throwable.printStackTrace();
                               }
                           }
                );
    }
}
