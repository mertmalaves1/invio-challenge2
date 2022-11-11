package com.example.invio_challenge.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.invio_challenge.R;
import com.example.invio_challenge.model.Movie;
import com.example.invio_challenge.view.MovieDetailActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context context;
    ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_list_item,viewGroup,false);
        context=viewGroup.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder viewHolder, int position) {
        Movie movie=movieArrayList.get(position);
        viewHolder.title.setText(movie.getTitle());
        viewHolder.year.setText(movie.getYear());
        viewHolder.type.setText(movie.getType());
        Glide.with(context).load(movie.getPoster()).into(viewHolder.imageView);
        viewHolder.itemView.setOnClickListener(view -> {
            Intent i = new Intent(context, MovieDetailActivity.class);
            i.putExtra("imdbID",movie.getImdb_id());
            context.startActivity(i);
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView title;
        public TextView year;
        public TextView type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.imageView);
            title= itemView.findViewById(R.id.txt_title);
            year= itemView.findViewById(R.id.txt_genre);
            type= itemView.findViewById(R.id.txt_type);
        }
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }
}
