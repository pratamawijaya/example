package com.pratamawijaya.blog.data.local;

import com.pratamawijaya.blog.model.database.PostTable;
import com.pratamawijaya.blog.model.pojo.Post;
import io.realm.Realm;
import io.realm.RealmResults;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public class DatabaseHelper {

  private Realm realm;

  @Inject public DatabaseHelper(Realm realm) {
    this.realm = realm;
  }

  public Observable<Post> insertPosts(final List<Post> posts) {
    return Observable.create(subscription -> {
      if (subscription.isUnsubscribed()) return;
      realm.executeTransaction(realmObject -> {
        PostTable postTable = new PostTable();
        realmObject.copyToRealmOrUpdate(postTable);
      }, new Realm.Transaction.Callback() {
        @Override public void onSuccess() {
          super.onSuccess();
          Timber.d("onSuccess(): insert post");
        }

        @Override public void onError(Exception e) {
          super.onError(e);
          Timber.e("onError(): error insert post %s", e.getLocalizedMessage());
        }
      });
    });
  }

  public Observable<List<Post>> getPosts() {
    return Observable.create(subscriber -> {
      RealmResults<PostTable> resultPost = realm.where(PostTable.class).findAllAsync();
      for (PostTable data : resultPost) {
        Timber.d("getPosts(): %s", data.getUrl());
      }
      // TODO: 1/1/16  onNext()
      // TODO: 1/1/16 onCompleted()
      // TODO: 1/1/16 onError()
    });
  }
}
