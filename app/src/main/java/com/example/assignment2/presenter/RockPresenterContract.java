package com.example.assignment2.presenter;

import com.example.assignment2.view.ViewContract;

public interface RockPresenterContract  {
    void bindView(ViewContract view);
    void initializeRetrofit();
    void getRockSongs();
    void onDestroy();
}
