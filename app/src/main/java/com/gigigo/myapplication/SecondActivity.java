package com.gigigo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

  private RecyclerView recycler;
  private  RecyclerView.Adapter adapter;
  private RecyclerView.LayoutManager layoutManager;



  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    recycler = (RecyclerView) findViewById(R.id.recycler);
    recycler.setHasFixedSize(true);
    layoutManager = new LinearLayoutManager(this);
    recycler.setLayoutManager(layoutManager);

    List<TemperatureData> temperatureList= Arrays.asList(new TemperatureData("mad","25"), new TemperatureData("bcn","30"));

    adapter = new MyAdapter(temperatureList);
    recycler.setAdapter(adapter);


  }
}
