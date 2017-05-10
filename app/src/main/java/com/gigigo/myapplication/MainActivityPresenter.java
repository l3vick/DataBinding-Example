package com.gigigo.myapplication;

import android.util.Log;

/**
 * Created by pablo.rojas on 9/5/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {
  private MainActivityContract.View view;

  public MainActivityPresenter(MainActivityContract.View view) {
    this.view = view;
  }


  @Override
  public void onShowData(TemperatureData temperatureData) {
    view.showData(temperatureData);
  }

  @Override
  public void showList() {
    view.startSecondActivity();
    Log.v("clicking"," button");
  }
}

