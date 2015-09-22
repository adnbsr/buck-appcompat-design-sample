package com.example.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import net.orange_box.storebox.StoreBox;
import timber.log.Timber;

public class MyFirstActivity extends AppCompatActivity {

  private Toolbar toolbar;
  private ImageView imageView;



  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this.toolbar = (Toolbar) findViewById(R.id.toolbar);
    this.imageView = (ImageView) findViewById(R.id.image);

    setSupportActionBar(toolbar);

    Timber.d("it works perfect!");

    Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageView);

    AppPreferences preferences = StoreBox.create(this,AppPreferences.class);

    Timber.d("token -> %s",preferences.getToken());


  }
}
