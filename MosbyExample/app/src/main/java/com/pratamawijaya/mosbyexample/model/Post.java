package com.pratamawijaya.mosbyexample.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/2/15
 * Project : MosbyExample
 */
public class Post implements Parcelable {
  private int id;
  private String title;
  private String content;
  private String date;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.title);
    dest.writeString(this.content);
    dest.writeString(this.date);
  }

  public Post() {
  }

  private Post(Parcel in) {
    this.id = in.readInt();
    this.title = in.readString();
    this.content = in.readString();
    this.date = in.readString();
  }

  public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {
    public Post createFromParcel(Parcel source) {
      return new Post(source);
    }

    public Post[] newArray(int size) {
      return new Post[size];
    }
  };
}
