package com.pratamawijaya.instagramlogin.models;

import java.util.List;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/18/15
 * Project : InstagramLogin
 */
public class UserMediaResponse {
  private Pagination pagination;
  private List<Post> data;

  public Pagination getPagination() {
    return pagination;
  }

  public void setPagination(Pagination pagination) {
    this.pagination = pagination;
  }

  public List<Post> getData() {
    return data;
  }

  public void setData(List<Post> data) {
    this.data = data;
  }
}
