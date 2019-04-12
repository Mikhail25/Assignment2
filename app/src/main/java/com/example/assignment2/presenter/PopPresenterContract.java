package com.example.assignment2.presenter;

import com.example.assignment2.view.ViewContract;

public interface PopPresenterContract {
    void bindView(ViewContract view);
    void initializeRetrofit();
    void getPopSongs();
    void onDestroy();
}
