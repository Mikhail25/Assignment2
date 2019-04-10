package com.example.assignment2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SongPojo {

    @SerializedName("resultCount")
    @Expose
    public Integer resultCount;
    @SerializedName("results")
    @Expose
    public List<Result> results;

/*    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Integer getResultCount() {
        return resultCount;
    }

    public List<Result> getResults() {
        return results;
    }*/
}
