package com.example.invio_challenge.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.invio_challenge.model.MovieDetail;

import com.example.invio_challenge.response.MovieResponse;
import com.example.invio_challenge.service.ApiRequest;
import com.example.invio_challenge.service.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.invio_challenge.constants.AppConstant.API_KEY;

public class MovieRepository {
    private static final String TAG = MovieRepository.class.getSimpleName();
    private ApiRequest apiRequest;
    private String  apiKey = API_KEY;
    public MovieRepository() {
        apiRequest = ServiceGenerator.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<MovieResponse> getMovies(String search_word ) {
        final MutableLiveData<MovieResponse> data = new MutableLiveData<>();
        apiRequest.searchMovie(apiKey,search_word).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                Log.d(TAG, "onResponse : " + response);
                if (response.body() != null) {
                    data.setValue(response.body());
                    Log.d(TAG, "totalMovies : " + response.body().getTotal_results());
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public LiveData<MovieDetail> getMovieDetail(String imdbID ) {
        final MutableLiveData<MovieDetail> data = new MutableLiveData<>();
        apiRequest.getMovieDetail(apiKey,imdbID).enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                Log.d(TAG, "onResponse : " + response);
                if (response.body() != null) {
                    data.setValue(response.body());
                    Log.d(TAG, "movie : " + response.body().getTitle());
                }
            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {

            }
        });
        return data;

    }
}
