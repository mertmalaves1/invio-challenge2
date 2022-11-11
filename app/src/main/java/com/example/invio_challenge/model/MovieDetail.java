package com.example.invio_challenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDetail {

    @SerializedName("Title")
    @Expose
    private String title;


    @SerializedName("Released")
    @Expose
    private String released;

    @SerializedName("Runtime")
    @Expose
    private String runtime;

    @SerializedName("Genre")
    @Expose
    private String genre;

    @SerializedName("Director")
    @Expose
    private String director;

    @SerializedName("Writer")
    @Expose
    private String writer;

    @SerializedName("Actors")
    @Expose
    private String actors;

    @SerializedName("Plot")
    @Expose
    private String plot;

    @SerializedName("Language")
    @Expose
    private String language;


    @SerializedName("Awards")
    @Expose
    private String awards;

    @SerializedName("Poster")
    @Expose
    private String Poster;

    @SerializedName("imdbRating")
    @Expose
    private String imdbRating;

    @SerializedName("imdbVotes")
    @Expose
    private String imdbVotes;



    public String getTitle() {
        return title;
    }



    public String getReleased() {
        return released;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getAwards() {
        return awards;
    }

    public String getPoster() {
        return Poster;
    }


    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }
}
