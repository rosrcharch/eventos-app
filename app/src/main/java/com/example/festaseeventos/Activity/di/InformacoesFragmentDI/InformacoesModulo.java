package com.example.festaseeventos.Activity.di.InformacoesFragmentDI;

import com.example.festaseeventos.Activity.api.FestaApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class InformacoesModulo {

    public static final String BASE_URL = "https://5e5ea581b5c43c0014ef9323.mockapi.io";

    @Provides
    public String[] cardViewNome(){

        return new String[] {"Categoria", "Festa de aniversario", "Bodas", "Datas comemorativas",
                "Casamento", "Corporativa", "Debutante", "Escolar", "Outros"};

    }

    @Provides
    public FestaApi getRetrofit(){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FestaApi.class);

    }


}
