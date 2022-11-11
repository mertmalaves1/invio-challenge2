package com.example.invio_challenge.response;

import com.example.invio_challenge.model.Movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    @SerializedName("Search")
    @Expose
    private List<Movie> data;

    @SerializedName("totalResults")
    @Expose
    private int total_results;

    @SerializedName("Response")
    @Expose
    private String response;

    public List<Movie> getData() {
        return data;
    }

    public void setData(List<Movie> data) {
        this.data = data;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
