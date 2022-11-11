package com.example.invio_challenge.service;

import com.example.invio_challenge.model.MovieDetail;
import com.example.invio_challenge.response.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {


    @GET("/")
    Call<MovieResponse> searchMovie(@Query("apikey") String apikey,
                               @Query("s") String search_word);

    @GET("/")
    Call<MovieDetail> getMovieDetail(@Query("apikey") String apikey,
                                     @Query("i") String imdbID);
}
