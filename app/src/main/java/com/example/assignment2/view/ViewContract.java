package com.example.assignment2.view;

import com.example.assignment2.model.SongPojo;

public interface ViewContract {
    void populateSong(SongPojo dataSet);
    void onError(String errorMessage);
}
