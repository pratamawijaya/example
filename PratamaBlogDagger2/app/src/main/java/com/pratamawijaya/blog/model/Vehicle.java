package com.pratamawijaya.blog.model;

import javax.inject.Inject;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/28/15
 * Project : PratamaBlogDagger2
 */
public class Vehicle {
  private Motor motor;

  @Inject
  public Vehicle(Motor motor) {
    this.motor = motor;
  }

  public void increaseSpeed(int value) {
    motor.accelerate(value);
  }

  public void stop() {
    motor.brake();
  }

  public int getSpeed() {
    return motor.getRpm();
  }
}
