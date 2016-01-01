package com.pratamawijaya.blog.model.database;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 1/1/16
 * Project : PratamaBlogDagger2
 */
public class PostTable extends RealmObject {
  @PrimaryKey private int id;
  private String type;
  private String url;
  private String status;
  private String title;
  private String content;
  private String excerpt;
  private String date;
  private String modified;
  private RealmList<CategoryTable> categorys;
  private AuthorTable author;

  public RealmList<CategoryTable> getCategorys() {
    return categorys;
  }

  public void setCategorys(RealmList<CategoryTable> categorys) {
    this.categorys = categorys;
  }

  private RealmList<AttachmentTable> attachments;

  public PostTable() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getExcerpt() {
    return excerpt;
  }

  public void setExcerpt(String excerpt) {
    this.excerpt = excerpt;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getModified() {
    return modified;
  }

  public void setModified(String modified) {
    this.modified = modified;
  }

  public AuthorTable getAuthor() {
    return author;
  }

  public void setAuthor(AuthorTable author) {
    this.author = author;
  }

  public RealmList<AttachmentTable> getAttachments() {
    return attachments;
  }

  public void setAttachments(RealmList<AttachmentTable> attachments) {
    this.attachments = attachments;
  }
}

