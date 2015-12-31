package com.pratamawijaya.blog.data;

import com.pratamawijaya.blog.data.local.DatabaseHelper;
import com.pratamawijaya.blog.data.network.PratamaService;
import com.pratamawijaya.blog.model.pojo.Post;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
@Singleton public class DataManager {
  private final PratamaService pratamaService;
  private final DatabaseHelper databaseHelper;

  @Inject public DataManager(PratamaService pratamaService, DatabaseHelper databaseHelper) {
    this.pratamaService = pratamaService;
    this.databaseHelper = databaseHelper;
  }

  public Observable<List<Post>> getPosts() {
    return null;
  }
}
