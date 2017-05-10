package com.gigigo.myapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.gigigo.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

  final int max = 10;
  Counter counter;



  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    View view = getWindow().getDecorView().getRootView();
    final ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
    TemperatureData temperatureData = new TemperatureData("madrid","30");
    MainActivityPresenter mainActivityPresenter = new MainActivityPresenter(this);
    binding.setTemp(temperatureData); // generated setter based on the data in the layout file
    binding.setPresenter(mainActivityPresenter);
    counter = new Counter(10,"pepe",true);
    binding.setCounter(counter);


    final Thread thread = new Thread(new Runnable() {
      @Override public void run() {
        for (int i = 0; i < max; i++) {
          int num = binding.getCounter().getNumber();
          num--;
          counter.setNumber(num);
          binding.setCounter(counter);
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {

          }
        }

      }
    });

    binding.btnCountDown.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
          try{
            thread.start();
          }catch (Exception e){
            Toast.makeText(MainActivity.this, "asdasdasdasd"+ e.getMessage(), Toast.LENGTH_SHORT).show();
          }



      }
    });

    binding.btnSayHello.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Your name is "+ binding.getCounter().getName(), Toast.LENGTH_SHORT).show();

      }
    });

  }

  @Override public void showData(TemperatureData temperatureData) {
    String celsius = temperatureData.getCelsius();
    Toast.makeText(this, celsius, Toast.LENGTH_SHORT).show();
  }

  @Override public void startSecondActivity() {
    Intent intent = new Intent(this, SecondActivity.class);
    startActivity(intent);
  }
}
