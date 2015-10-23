package com.pratamawijaya.realmio.model;

import io.realm.RealmObject;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/18/15
 * Project : RealmIO
 */
public class User extends RealmObject {
  private String name;
  private String addres;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddres() {
    return addres;
  }

  public void setAddres(String addres) {
    this.addres = addres;
  }
}
