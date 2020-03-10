package com.example.festaseeventos.Activity.Fragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.festaseeventos.Activity.Adapter.ServicosAdapter;
import com.example.festaseeventos.Activity.Interface.RecyclerViewOnItemClick;
import com.example.festaseeventos.Activity.Model.Servicos;
import com.example.festaseeventos.R;

import java.util.ArrayList;
import java.util.List;

public class ListaFragment extends Fragment implements RecyclerViewOnItemClick {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Servicos> listaServicos = new ArrayList<>();
    public Button btnOpcao;
    public ServicosAdapter adapter;
    private ImageView imgAdicionar;
    private EditText edtAdicionar;
    public LinearLayout linOpcao;

    public ListaFragment() {

        setHasOptionsMenu(true);
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        btnOpcao = view.findViewById(R.id.buttonOpcoes);
        recyclerView = view.findViewById(R.id.recycler_view);
        linOpcao = view.findViewById(R.id.linearImage);
        imgAdicionar = view.findViewById(R.id.imageAdicionar);
        edtAdicionar = view.findViewById(R.id.textAdicionar);

        //tamanho da lista inalteravel pelo seu conteudo
        recyclerView.setHasFixedSize(true);


        // Configurar o lyoutManager e o adapter
        adapter = new ServicosAdapter(criarServicos(), getActivity());
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter.setRecyclerViewOnItemClick(this);
        recyclerView.setAdapter(adapter);

        setHasOptionsMenu(true);

        imgAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Servicos servicos = new Servicos();
                listaServicos.add(servicos);
                servicos.setNome(edtAdicionar.getText().toString());
                adapter.notifyDataSetChanged();

            }
        });




        return view;
    }


    public List<Servicos> criarServicos() {

        Servicos servicos = new Servicos("Bebidas");
        this.listaServicos.add(servicos);

        servicos = new Servicos("Decoração");
        this.listaServicos.add(servicos);

        servicos = new Servicos("Comidas");
        this.listaServicos.add(servicos);

        servicos = new Servicos("Convites");
        this.listaServicos.add(servicos);

        servicos = new Servicos("Garçon");
        this.listaServicos.add(servicos);

        servicos = new Servicos("DJ");
        this.listaServicos.add(servicos);

        servicos = new Servicos("Fotografia");
        this.listaServicos.add(servicos);

        servicos = new Servicos("Recreação");
        this.listaServicos.add(servicos);

        servicos = new Servicos("Brinquedos");
        this.listaServicos.add(servicos);

        servicos = new Servicos("Mágico");
        this.listaServicos.add(servicos);

        servicos = new Servicos("Recepsionista");
        this.listaServicos.add(servicos);

        servicos = new Servicos("Segurança");
        this.listaServicos.add(servicos);

        servicos = new Servicos("Stand up");
        this.listaServicos.add(servicos);

        servicos = new Servicos("Cantor/Banda");
        this.listaServicos.add(servicos);

        servicos = new Servicos("Karaokê");
        this.listaServicos.add(servicos);

        servicos = new Servicos("Barman");
        this.listaServicos.add(servicos);

        return listaServicos;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.convidados_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onClickListener(View view, int position) {

        Toast.makeText(getActivity(), "onClickListener: "+position, Toast.LENGTH_SHORT).show();
        ServicosAdapter adapter = (ServicosAdapter) recyclerView.getAdapter();

    }

    @Override
    public void onLongClickListener(View view, int position) {

    }


}