package com.pratamawijaya.blog.model.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 1/1/16
 * Project : PratamaBlogDagger2
 */
public class ImagesFullTable extends RealmObject {
  @PrimaryKey private String url;
  private int width;
  private int height;

  public ImagesFullTable() {
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
