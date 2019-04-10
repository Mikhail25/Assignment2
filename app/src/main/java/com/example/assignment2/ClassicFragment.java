package com.example.assignment2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ClassicFragment extends Fragment {

    RecyclerView recyclerView;
    SongPojo list;
    SongsApi api;
    CustomAdapter custAdapt;

    public ClassicFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // The Handle to the Recycler View
        View rootView = inflater.inflate(R.layout.fragment_classic, container, false);


        //Create the adapter and supply the data
        custAdapt = new CustomAdapter(list, getContext());
        initializeRetrofit();


        recyclerView = rootView.findViewById(R.id.recyclerViewClassic);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        getClassicSongs();


        return rootView;
    }

    private void getClassicSongs() {
        api.getClassicSong().enqueue(new Callback<SongPojo>() {
            @Override
            public void onResponse(Call<SongPojo> call, Response<SongPojo> response) {
                //Log.e("RockFragment", "Inside onResponse Method");
                recyclerView.setAdapter(new CustomAdapter(response.body(),getContext()));

            }

            @Override
            public void onFailure(Call<SongPojo> call, Throwable t) {
                Toast.makeText(getActivity(), "Something Failed...", Toast.LENGTH_LONG);
            }
        });
    }

    private void initializeRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://itunes.apple.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(SongsApi.class);

    }

}
