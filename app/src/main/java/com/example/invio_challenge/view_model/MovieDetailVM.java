package com.example.invio_challenge.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.invio_challenge.model.MovieDetail;
import com.example.invio_challenge.repository.MovieRepository;


public class MovieDetailVM extends AndroidViewModel {

    private MovieRepository movieRepository;
    private LiveData<MovieDetail> movieDetailLiveData;

    public MovieDetailVM(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository();
    }

    public LiveData<MovieDetail> getMovieDetailLiveData(String imdbID) {
        this.movieDetailLiveData = movieRepository.getMovieDetail(imdbID);
        return movieDetailLiveData;
    }

}
