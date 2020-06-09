package com.example.festaseeventos.Activity.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.festaseeventos.Activity.Model.Festa;
import com.example.festaseeventos.Activity.api.FestaApi;
import com.example.festaseeventos.Activity.di.InformacoesFragmentDI.DaggerInformacoesComponent;
import com.example.festaseeventos.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EscolhaFragment extends Fragment {

    @Inject
    FestaApi api;
    @Inject
    Festa festa;
    private TextView tipo;
    private TextView data;
    private TextView local;
    private TextView convidados;
    public static int num = 0;

    public EscolhaFragment() {
        // Required empty public constructor
        DaggerInformacoesComponent.create().inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_escolha, container, false);
        tipo = view.findViewById(R.id.tipo);
        data = view.findViewById(R.id.data);
        local = view.findViewById(R.id.local);
        convidados = view.findViewById(R.id.convidados);

        getListaFesta();

        return view;
    }

    public void getListaFesta(){
        Call<Festa> call = api.getListaFesta(num);
        call.enqueue(new Callback<Festa>() {
            @Override
            public void onResponse(Call<Festa> call, Response<Festa> response) {

                try {

                    festa = response.body();
                    tipo.setText(festa.getTipoFesta());
                    data.setText(festa.getDataFesta());
                    local.setText(festa.getLocalFesta());
                    convidados.setText(festa.getQuantidadeConvidados());

                }catch (Exception e){
                    Log.d("erro" , "onResponse: campo vazio "+ e);
                }
            }

            @Override
            public void onFailure(Call<Festa> call, Throwable t) {

            }
        });
    }



}
