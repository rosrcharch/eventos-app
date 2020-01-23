package com.example.festaseeventos.Activity.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.festaseeventos.Activity.Adapter.Adapter;
import com.example.festaseeventos.Activity.Model.Convidado;
import com.example.festaseeventos.R;

import java.util.ArrayList;
import java.util.List;

public class ListaFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Convidado> listaServicos = new ArrayList<>();
    private EditText testoAdicionar;
    private ImageView imagemAdicionar;


    public ListaFragment() {

        setHasOptionsMenu(true);
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        recyclerView = view.findViewById(R.id.lista_recycler);

        //Configurar a lista de convidados
        this.criarServicos();


        //tamanho da lista inalteravel pelo seu conteudo
        recyclerView.setHasFixedSize(true);

        //Configurar o divisor
        /*recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));*/


        // Configurar o lyoutManager
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Configurr o Adapter
        Adapter adapter = new Adapter(listaServicos);
        recyclerView.setAdapter( adapter );

        setHasOptionsMenu(true);


        return view;
    }

    public void criarServicos(){

        Convidado convidado = new Convidado("Bebidas");
        this.listaServicos.add(convidado);

        convidado = new Convidado("Decoração");
        this.listaServicos.add(convidado);

        convidado = new Convidado("Comidas");
        this.listaServicos.add(convidado);

        convidado = new Convidado("Convites");
        this.listaServicos.add(convidado);

        convidado = new Convidado("Garçon");
        this.listaServicos.add(convidado);

        convidado = new Convidado("DJ");
        this.listaServicos.add(convidado);

        convidado = new Convidado("Filmagem");
        this.listaServicos.add(convidado);

        convidado = new Convidado("Recreação");
        this.listaServicos.add(convidado);

        convidado = new Convidado("Brinquedos");
        this.listaServicos.add(convidado);

        convidado = new Convidado("Mágico");
        this.listaServicos.add(convidado);

        convidado = new Convidado("Recepsionista");
        this.listaServicos.add(convidado);

        convidado = new Convidado("Retrospectiva");
        this.listaServicos.add(convidado);

        convidado = new Convidado("Segurança");
        this.listaServicos.add(convidado);

        convidado = new Convidado("Stand up");
        this.listaServicos.add(convidado);

        convidado = new Convidado("Cantor/Banda");
        this.listaServicos.add(convidado);

        convidado = new Convidado("Karaokê");
        this.listaServicos.add(convidado);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.convidados_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }



}
