package com.pratamawijaya.exampledatabinding.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 7/31/15
 * Project : ExampleDataBinding
 */
public class User implements Parcelable {
  private String name;
  private String email;

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.name);
    dest.writeString(this.email);
  }

  protected User(Parcel in) {
    this.name = in.readString();
    this.email = in.readString();
  }

  public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
    public User createFromParcel(Parcel source) {
      return new User(source);
    }

    public User[] newArray(int size) {
      return new User[size];
    }
  };
}
