package com.example.pixibay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    PixabayAdapter adapter;
    int currentPage = 0;
    HashMap<String, String> map = new HashMap<>();
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rv = findViewById(R.id.idrv);



        retrofit = new Retrofit();





        init();



        loadNextPage();



    }



    void init () {

        map.put("key", "3968517-94dbe52e08b9ec52249a64fdc");
        map.put("q", "animal");
        map.put("image_type", "all");
        map.put("page", "1");
        Call<PixabayResponse> call = retrofit.getService(PixabayService.class).getImages(map);
        call.enqueue(new Callback<PixabayResponse>() {
            @Override
            public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                PixabayResponse pixabayResponse = response.body();
                List<Hit> hits = pixabayResponse.getHits();
                adapter = new PixabayAdapter(getApplicationContext(), hits);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                currentPage = 1;
            }

            @Override
            public void onFailure(Call<PixabayResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void loadNextPage() {

        map.put("page", (currentPage + 1) + "");

        Call<PixabayResponse> call = retrofit.getService(PixabayService.class).getImages(map);
        call.enqueue(new Callback<PixabayResponse>() {
            @Override
            public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                PixabayResponse pixabayResponse = response.body();
                List<Hit> hits = pixabayResponse.getHits();
                adapter.addItems(hits);
                currentPage++;
            }

            @Override
            public void onFailure(Call<PixabayResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}