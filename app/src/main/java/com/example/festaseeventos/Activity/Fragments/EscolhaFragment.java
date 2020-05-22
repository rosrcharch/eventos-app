package com.example.festaseeventos.Activity.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
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
import com.example.festaseeventos.Activity.util.TheFesta;
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
    @BindView(R.id.tipo)
    TextView tipo;
    @BindView(R.id.data)
    TextView data;
    @BindView(R.id.local)
    TextView local;
    @BindView(R.id.convidados)
    TextView convidados;

    public EscolhaFragment() {
        // Required empty public constructor
        DaggerInformacoesComponent.create().inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_escolha, container, false);

        getListaFesta();
        ButterKnife.bind(this, view);

        return view;
    }

    public void getListaFesta(){
        Call<Festa> call = api.getListaFesta(1);
        call.enqueue(new Callback<Festa>() {
            @Override
            public void onResponse(Call<Festa> call, Response<Festa> response) {

                festa = response.body();
                tipo.setText(festa.getTipoFesta());
                data.setText(festa.getDataFesta());
                local.setText(festa.getLocalFesta());
                convidados.setText(festa.getQuantidadeConvidados());
            }

            @Override
            public void onFailure(Call<Festa> call, Throwable t) {

            }
        });
    }



}
