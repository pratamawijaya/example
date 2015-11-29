package com.pratamawijaya.blog.model;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
public class Motor {
  private int rpm;

  public int getRpm() {
    return rpm;
  }

  public void setRpm(int rpm) {
    this.rpm = rpm;
  }

  public void accelerate(int value) {
    rpm = rpm + value;
  }

  public void brake() {
    rpm = 0;
  }
}
