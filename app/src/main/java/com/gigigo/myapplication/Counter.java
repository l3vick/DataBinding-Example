package com.gigigo.myapplication;

/**
 * Created by pablo.rojas on 8/5/17.
 */

public class Counter {

  private int number;
  private String name;
  private boolean visible;

  public Counter(int number) {
    this.number = number;
  }

  public Counter(int number, String name, boolean visible) {
    this.number = number;
    this.name = name;
    this.visible = visible;
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

}
