package com.example.invio_challenge.view;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.invio_challenge.R;
import com.example.invio_challenge.view_model.MovieDetailVM;



public class MovieDetailActivity extends BaseView {

    TextView txt_title,txt_genre,txt_runtime,txt_language,txt_released,txt_imdb_rating,txt_imdb_votes,txt_plot,txt_director,txt_writer,txt_actors,txt_awards;
    ImageView imageView;
    MovieDetailVM movieDetailVM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        initialization();
        MovieDetailActivity.super.showProgress(this,"Loading...");
        Intent i= getIntent();
        Bundle myBundle = i.getExtras();
        String imdbID=myBundle.getString("imdbID");
        getMovieDetailData(imdbID);
    }

    private void getMovieDetailData(String imbdID) {

        movieDetailVM.getMovieDetailLiveData(imbdID).observe(MovieDetailActivity.this, movieDetail -> {
            if (movieDetail !=null){
                txt_title.setText(movieDetail.getTitle());
                txt_genre.setText(movieDetail.getGenre());
                txt_runtime.setText(movieDetail.getRuntime());
                txt_language.setText(movieDetail.getLanguage());
                txt_released.setText(movieDetail.getReleased());
                txt_imdb_rating.setText(movieDetail.getImdbRating());
                txt_imdb_votes.setText(movieDetail.getImdbVotes()+" Votes");
                txt_plot.setText(movieDetail.getPlot());
                txt_director.setText(movieDetail.getDirector());
                txt_writer.setText(movieDetail.getWriter());
                txt_actors.setText(movieDetail.getActors());
                txt_awards.setText(movieDetail.getAwards());
                Glide.with(this).load(movieDetail.getPoster()).into(imageView);
                MovieDetailActivity.super.dismissProgress();
            }

        });
    }

    private void initialization() {
        movieDetailVM = ViewModelProviders.of(this).get(MovieDetailVM.class);
        imageView = findViewById(R.id.imageView);
        txt_title = findViewById(R.id.txt_title);
        txt_genre = findViewById(R.id.txt_genre);
        txt_runtime = findViewById(R.id.txt_runtime);
        txt_language = findViewById(R.id.txt_language);
        txt_released = findViewById(R.id.txt_released);
        txt_imdb_rating = findViewById(R.id.txt_imdb_rating);
        txt_imdb_votes = findViewById(R.id.txt_imdb_votes);
        txt_plot = findViewById(R.id.txt_plot);
        txt_director = findViewById(R.id.txt_director);
        txt_writer = findViewById(R.id.txt_writer);
        txt_actors = findViewById(R.id.txt_actors);
        txt_awards = findViewById(R.id.txt_awards);
    }
}