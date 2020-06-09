package com.example.festaseeventos.Activity.api;

import com.example.festaseeventos.Activity.Model.Festa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FestaApi {

    @GET("/festa/{id}")
    Call<Festa> getListaFesta(@Path("id")int id);

    @POST("festa")
    Call<Festa> setListaFesta(@Body Festa festa);
}
