package com.pratamawijaya.instagramlogin.models;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/18/15
 * Project : InstagramLogin
 */
public class Post {
  private String type;
  private String created_time;
  private String link;
  private Images images;
  private Caption caption;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCreated_time() {
    return created_time;
  }

  public void setCreated_time(String created_time) {
    this.created_time = created_time;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public Images getImages() {
    return images;
  }

  public void setImages(Images images) {
    this.images = images;
  }

  public Caption getCaption() {
    return caption;
  }

  public void setCaption(Caption caption) {
    this.caption = caption;
  }
}
