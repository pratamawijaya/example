package com.pratamawijaya.instagramlogin.views.feed;

import com.pratamawijaya.instagramlogin.models.Post;
import java.util.List;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/18/15
 * Project : InstagramLogin
 */
public interface FeedUserInterface {
  void showData(List<Post> posts);

  void showLoading();

  void hideLoading();
}
