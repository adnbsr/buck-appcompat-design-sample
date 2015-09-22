package com.example.activity;

import android.app.Application;
import timber.log.Timber;

/**
 * Created by adnan on 9/22/15.
 */
public class App extends Application {

  @Override public void onCreate() {
    super.onCreate();


    Timber.plant(new Timber.DebugTree());


  }
}
