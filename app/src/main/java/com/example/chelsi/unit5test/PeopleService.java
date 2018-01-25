package com.example.chelsi.unit5test;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Chelsi on 1/24/2018.
 */

public interface PeopleService {

    @GET("api/")
    Call<PeopleResponse> getPeople(@Query("results") String results);
}
