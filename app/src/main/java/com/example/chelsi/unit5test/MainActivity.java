package com.example.chelsi.unit5test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String BASE_URL = "https://randomuser.me/";
    private ArrayList<People> peopleArrayList;
    private RecyclerView recyclerView;
    private PeopleAdapter peopleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setAdapter(peopleAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
      PeopleService peopleService = retrofit.create(PeopleService.class);
        Call<PeopleResponse> peopleResponseCall = peopleService.getPeople();
        peopleResponseCall.enqueue(new Callback<PeopleResponse>() {
            @Override
            public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
                Log.d("response", "onResponse: working"+ response.toString());

                peopleArrayList = response.body().getResults();
                peopleAdapter = new PeopleAdapter(peopleArrayList);
                recyclerView.setAdapter(peopleAdapter);
                recyclerView.setLayoutManager(gridLayoutManager);
            }

            @Override
            public void onFailure(Call<PeopleResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


}
