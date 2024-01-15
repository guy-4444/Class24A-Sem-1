package com.guy.class24a_sem_1.generic;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.guy.class24a_sem_1.Movie;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class GenericController implements Callback<ResponseBody> {

    static final String BASE_URL = "";

    private CallBack_Generic callBackGeneric;


    public GenericController(CallBack_Generic callBackGeneric) {
        this.callBackGeneric = callBackGeneric;
    }

    public void fetchData(String url) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://a/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GenericApi genericApi = retrofit.create(GenericApi.class);

        url = url.charAt(url.length()-1) == '/' ? url.substring(0, url.length()-1) : url;
        Call<ResponseBody> call = genericApi.fetch(url);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if (response.isSuccessful()) {
            try {
                String data = response.body().string();
                callBackGeneric.success(data);
            } catch (IOException e) {
                callBackGeneric.error("" + response.errorBody());
                throw new RuntimeException(e);
            }
        } else {
            callBackGeneric.error("" + response.errorBody());
        }

    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        callBackGeneric.error("" + t.getMessage());
    }

    public interface GenericApi {

        @GET
        Call<ResponseBody> fetch(@Url String url);

    }

    public interface CallBack_Generic {
        void success(String data);
        void error(String error);
    }
}
