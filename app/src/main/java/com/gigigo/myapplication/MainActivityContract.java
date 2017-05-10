package com.gigigo.myapplication;

/**
 * Created by pablo.rojas on 9/5/17.
 */

public interface MainActivityContract {
  public interface Presenter {
    void onShowData(TemperatureData temperatureData);
    void showList();
  }

  public interface View {
    void showData(TemperatureData temperatureData);
    void startSecondActivity();
  }

}
