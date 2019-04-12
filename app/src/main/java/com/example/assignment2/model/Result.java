package com.example.assignment2.model;

import android.net.Uri;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    //
    @SerializedName("artistName")
    @Expose
    private String artistName;
    @SerializedName("collectionName")
    @Expose
    private String collectionName;
    @SerializedName("artworkUrl60")
    @Expose
    private String artworkUrl60;
    @SerializedName("trackPrice")
    @Expose
    private String trackPrice;
    @SerializedName("previewUrl")
    @Expose
    private String previewUrl;

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public String getTrackPrice() {
        return trackPrice;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public void setTrackPrice(String trackPrice) {
        this.trackPrice = trackPrice;
    }
}
