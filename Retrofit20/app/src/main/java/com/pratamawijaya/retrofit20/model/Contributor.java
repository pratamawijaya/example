package com.pratamawijaya.retrofit20.model;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/11/15
 * Project : Retrofit20
 */
public class Contributor {
  private String login;
  private int contributions;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public int getContributions() {
    return contributions;
  }

  public void setContributions(int contributions) {
    this.contributions = contributions;
  }
}
