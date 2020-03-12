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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.festaseeventos.Activity.Adapter.ServicosAdapter;
import com.example.festaseeventos.Activity.Interface.RecyclerViewOnItemClick;
import com.example.festaseeventos.Activity.Model.Servicos;

import com.example.festaseeventos.Activity.di.ListaFragmentDI.DaggerApiComponent;
import com.example.festaseeventos.Activity.di.ListaFragmentDI.ListaModulo;
import com.example.festaseeventos.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListaFragment extends Fragment implements RecyclerViewOnItemClick {

    @Inject
    RecyclerView recyclerView;
    @BindView(R.id.buttonOpcoes)
     Button btnOpcao;
    @BindView(R.id.linearImage)
    LinearLayout linOpcao;
    @Inject
    Servicos servicos;
    @Inject
    ArrayList<Servicos> listaServicos;
    ServicosAdapter adapter;

    public ListaFragment() {

        setHasOptionsMenu(true);
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        DaggerApiComponent.builder().listaModulo(new ListaModulo(view)).build().inject(this);
        ButterKnife.bind(this, view);

        //tamanho da lista inalteravel pelo seu conteudo
        recyclerView.setHasFixedSize(true);

        // Configurar o lyoutManager e o adapter
        adapter = new ServicosAdapter(listaServicos, getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setRecyclerViewOnItemClick(this);
        recyclerView.setAdapter(adapter);

        setHasOptionsMenu(true);



        return view;
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