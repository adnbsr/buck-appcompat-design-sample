package com.example.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MyFirstActivity extends AppCompatActivity {

  private Toolbar toolbar;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this.toolbar = (Toolbar) findViewById(R.id.toolbar);

    setSupportActionBar(toolbar);

  }
}
