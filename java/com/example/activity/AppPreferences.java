package com.example.activity;

import net.orange_box.storebox.annotations.method.KeyByString;

/**
 * Created by adnan on 9/22/15.
 */
public interface AppPreferences {

  @KeyByString("token")
  void setToken(String token);

  @KeyByString("token")
  String getToken();


}
