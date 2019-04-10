package com.example.assignment2;

import java.lang.annotation.Target;

import retrofit2.Call;
import retrofit2.http.GET;

interface SongsApi {
    @GET("search?term=rock&amp;amp;media=music&amp;amp;entity=song&amp;amp;limit=50")
    Call<SongPojo> getRockSong();

    @GET("search?term=classick&amp;amp;media=music&amp;amp;entity=song&amp;amp;limit=50")
    Call<SongPojo> getClassicSong();

    @GET("search?term=pop&amp;amp;media=music&amp;amp;entity=song&amp;amp;limit=50")
    Call<SongPojo> getPopSong();
}
