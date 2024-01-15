package com.guy.class24a_sem_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.guy.class24a_sem_1.generic.GenericController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private MaterialButton main_BTN_getMovies;

    // https://pastebin.com/raw/uWcaqqs9
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_BTN_getMovies = findViewById(R.id.main_BTN_getMovies);
        main_BTN_getMovies.setOnClickListener(v -> getData("https://pastebin.com/raw/xt4Us2d0"));
    }

    private void getData(String url) {
        new GenericController(new GenericController.CallBack_Generic() {
            @Override
            public void success(String data) {
                Log.d("pttt", "Data: " + data);
            }

            @Override
            public void error(String error) {

            }
        }).fetchData(url);
    }

    private void getMovie(String id) {
        // getMovie("uWcaqqs9")
        MoviesControllerPro.CallBack_Movies callBackMovies = new MoviesControllerPro.CallBack_Movies() {
            @Override
            public void success(Movie movie) {
                Log.d("pttt", movie.getTitle());
                int x = 0;
            }

            @Override
            public void success(List<Movie> movies) {

            }

            @Override
            public void error(String error) {

            }
        };

        new MoviesControllerPro(callBackMovies).fetchMovieByID(id);
    }

    private void getAllMovies() {
        MoviesController.CallBack_Movies callback = new MoviesController.CallBack_Movies() {
            @Override
            public void success(List<Movie> movies) {
                // refresh ui / update list
            }

            @Override
            public void error(String error) {
                // notify user..
            }
        };
        new MoviesController(callback).fetchAllMovies();

    }

}


