package com.guy.class24a_sem_1;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesControllerPro {

    static final String BASE_URL = "https://pastebin.com/";

    private CallBack_Movies callBackMovies;


    public MoviesControllerPro(CallBack_Movies callBackMovies) {
        this.callBackMovies = callBackMovies;
    }

    public void fetchAllMovies() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MoviesApi moviesAPI = retrofit.create(MoviesApi.class);

        Call<List<Movie>> call = moviesAPI.loadMovies();
        call.enqueue(internalMoviesCallBack);
    }

    public void fetchMovieByID(String movieID) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MoviesApi moviesAPI = retrofit.create(MoviesApi.class);

        Call<Movie> call = moviesAPI.loadMovieByKey(movieID);
        call.enqueue(internalOneMovieCallBack);
    }

    private Callback<List<Movie>> internalMoviesCallBack = new Callback<List<Movie>>() {
        @Override
        public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
            if (response.isSuccessful()) {
                List<Movie> movies = response.body();
                callBackMovies.success(movies);
                int x = 0;
            } else {
                callBackMovies.error("" + response.errorBody());
                Log.d("pttt", "" + response.errorBody());
            }
        }

        @Override
        public void onFailure(Call<List<Movie>> call, Throwable t) {
            callBackMovies.error(t.getMessage());
            t.printStackTrace();
        }
    };

    private Callback<Movie> internalOneMovieCallBack = new Callback<Movie>() {
        @Override
        public void onResponse(Call<Movie> call, Response<Movie> response) {
            if (response.isSuccessful()) {
                callBackMovies.success(response.body());
            } else {
                callBackMovies.error("" + response.errorBody());
            }
        }

        @Override
        public void onFailure(Call<Movie> call, Throwable t) {
            callBackMovies.error(t.getMessage());
            t.printStackTrace();
        }
    };



    public interface CallBack_Movies {
        void success(Movie movie);
        void success(List<Movie> movies);
        void error(String error);
    }
}
