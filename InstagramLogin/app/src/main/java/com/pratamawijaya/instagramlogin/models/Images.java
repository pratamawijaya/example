package com.pratamawijaya.instagramlogin.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/18/15
 * Project : InstagramLogin
 */
public class Images {
  @SerializedName("low_resolution") private Data lowResolution;
  @SerializedName("thumbnail") private Data thumbnail;
  @SerializedName("standard_resolution") private Data standardResolution;

  public Data getLowResolution() {
    return lowResolution;
  }

  public void setLowResolution(Data lowResolution) {
    this.lowResolution = lowResolution;
  }

  public Data getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(Data thumbnail) {
    this.thumbnail = thumbnail;
  }

  public Data getStandardResolution() {
    return standardResolution;
  }

  public void setStandardResolution(Data standardResolution) {
    this.standardResolution = standardResolution;
  }

  public class Data {
    private String url;
    private int width;
    private int height;

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
}
