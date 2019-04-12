package com.example.assignment2.presenter;

import com.example.assignment2.view.ViewContract;

public interface ClassicPresenterContract {
    void bindView(ViewContract view);
    void initializeRetrofit();
    void getClassicSongs();
    void onDestroy();
}
