package com.example.assignment2.presenter;

import android.view.ViewGroup;
import android.widget.Toast;

import com.example.assignment2.model.SongPojo;
import com.example.assignment2.model.SongsApi;
import com.example.assignment2.view.CustomAdapter;
import com.example.assignment2.view.ViewContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RockPresenter implements RockPresenterContract {
    ViewContract view;
    SongsApi api;

    public RockPresenter(ViewContract view) {
        this.view = view;
    }

    @Override
    public void bindView(ViewContract view) {
        this.view = view;
    }

    @Override
    public void initializeRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://itunes.apple.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(SongsApi.class);
    }

    @Override
    public void getRockSongs() {
        api.getRockSong().enqueue(new Callback<SongPojo>() {
            @Override
            public void onResponse(Call<SongPojo> call, Response<SongPojo> response) {
                //Log.e("RockFragment", "Inside onResponse Method");
                view.populateSong(response.body());
            }

            @Override
            public void onFailure(Call<SongPojo> call, Throwable t) {
                view.onError(t.getMessage());
            }
        });
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
