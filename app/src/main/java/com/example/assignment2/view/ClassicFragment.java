package com.example.assignment2.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.assignment2.R;
import com.example.assignment2.model.SongPojo;
import com.example.assignment2.model.SongsApi;
import com.example.assignment2.presenter.ClassicPresenter;
import com.example.assignment2.presenter.ClassicPresenterContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ClassicFragment extends Fragment implements ViewContract{

    RecyclerView recyclerView;
    ClassicPresenterContract classicPresenter;

    public ClassicFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // The Handle to the Recycler View
        View rootView = inflater.inflate(R.layout.fragment_classic, container, false);


        //Create the adapter and supply the data
        classicPresenter = new ClassicPresenter(this);
        classicPresenter.initializeRetrofit();


        recyclerView = rootView.findViewById(R.id.recyclerViewClassic);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        classicPresenter.getClassicSongs();


        return rootView;
    }


    @Override
    public void populateSong(SongPojo dataSet) {
        recyclerView.setAdapter(new CustomAdapter(dataSet, getContext()));
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getContext(),errorMessage, Toast.LENGTH_SHORT).show();

    }
}
