package com.pratamawijaya.blog.model.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 1/1/16
 * Project : PratamaBlogDagger2
 */
public class AttachmentTable extends RealmObject {
  @PrimaryKey private int id;
  private String url;
  private String slug;
  private String title;
  private String description;
  private String caption;
  private int parent;
  private String mime_type;
  private ImagesTable images;

  public AttachmentTable() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public int getParent() {
    return parent;
  }

  public void setParent(int parent) {
    this.parent = parent;
  }

  public String getMime_type() {
    return mime_type;
  }

  public void setMime_type(String mime_type) {
    this.mime_type = mime_type;
  }

  public ImagesTable getImages() {
    return images;
  }

  public void setImages(ImagesTable images) {
    this.images = images;
  }
}
