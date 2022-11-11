package com.example.invio_challenge.view;


import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.invio_challenge.R;
import com.example.invio_challenge.adapter.MovieAdapter;
import com.example.invio_challenge.model.Movie;
import com.example.invio_challenge.view_model.MovieVM;
import java.util.ArrayList;
import java.util.List;

public class MovieSearchActivity extends BaseView {

    MovieVM movieVM;
    ImageButton btn_search;
    EditText edt_query;
    RecyclerView movieRV;
    private LinearLayoutManager layoutManager;
    private MovieAdapter adapter;
    private ArrayList<Movie> movieArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_search);
        initialization();

        btn_search.setOnClickListener(view -> {
            if (edt_query.getText().toString().length() >=3){
                MovieSearchActivity.super.showProgress(MovieSearchActivity.this,"Loading...");
                movieVM.getMovieLiveData(edt_query.getText().toString()).observe(MovieSearchActivity.this, movieResponse -> {
                    if (movieResponse !=null){
                        List<Movie> movies = movieResponse.getData();
                        movieArrayList.clear();
                        movieArrayList.addAll(movies);
                        adapter = new MovieAdapter(MovieSearchActivity.this, movieArrayList);
                        movieRV.setAdapter(adapter);
                        MovieSearchActivity.super.dismissProgress();
                    }
                });
            }else{
                MovieSearchActivity.super.showToast(MovieSearchActivity.this,"At least 3 character.");
            }
        });
    }

    private void initialization() {
        movieVM = ViewModelProviders.of(this).get(MovieVM.class);
        edt_query = findViewById(R.id.edt_query);
        btn_search = findViewById(R.id.btn_search);
        movieRV = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(MovieSearchActivity.this);
        movieRV.setLayoutManager(layoutManager);
    }
}