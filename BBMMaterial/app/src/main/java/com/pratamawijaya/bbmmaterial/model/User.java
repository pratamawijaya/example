package com.pratamawijaya.bbmmaterial.model;

/**
 * Created by pratama on 6/27/15.
 */
public class User {
  private String userName;
  private String userProfilePicture;
  private String userStatus;

  public User() {
  }

  public User(String userName, String userProfilePicture, String userStatus) {
    this.userName = userName;
    this.userProfilePicture = userProfilePicture;
    this.userStatus = userStatus;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserProfilePicture() {
    return userProfilePicture;
  }

  public void setUserProfilePicture(String userProfilePicture) {
    this.userProfilePicture = userProfilePicture;
  }

  public String getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(String userStatus) {
    this.userStatus = userStatus;
  }
}
