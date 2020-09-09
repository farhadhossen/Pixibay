package com.example.pixibay;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface PixabayService {
    @GET("api")
    Call<PixabayResponse> getImages(@QueryMap Map<String, String> parameter);
}