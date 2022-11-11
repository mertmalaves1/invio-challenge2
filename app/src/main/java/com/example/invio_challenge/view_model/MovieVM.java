package com.example.invio_challenge.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.invio_challenge.repository.MovieRepository;
import com.example.invio_challenge.response.MovieResponse;

public class MovieVM extends AndroidViewModel {

    private MovieRepository movieRepository;
    private LiveData<MovieResponse> movieLiveData;

    public MovieVM(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository();
    }

    public LiveData<MovieResponse> getMovieLiveData(String search_word) {
        this.movieLiveData = movieRepository.getMovies(search_word);
        return movieLiveData;
    }
}
