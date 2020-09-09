package com.example.pixibay;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    String baseUrl = "https://pixabay.com/";


    Context context;

    public <T> T getService(Class<T> serviceClass) {
        return getRetrofit().create(serviceClass);
    }

    public synchronized retrofit2.Retrofit getRetrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        OkHttpClient client = httpClient.build();
        return new retrofit2.Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}