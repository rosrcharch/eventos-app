package com.example.festaseeventos.Activity.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.festaseeventos.R;

public class InformacoesFragment extends Fragment {

    private EditText editLocalFesta;
    private EditText editData;
    private EditText editNumConvidados;
    private RatingBar classificacaoFesta;

    private String[] cardViewNome = new String[] {"Festa de aniversario", "Bodas", "Datas comemorativas",
    "Casamento", "Corporativa", "Debutante", "Escolar", "Outros"};


    // Required empty public constructor
    public InformacoesFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_informacoes, container, false);


        editLocalFesta = view.findViewById(R.id.edit_local_festa);
        editData = view.findViewById(R.id.edit_data);
        editNumConvidados = view.findViewById(R.id.edit_num_convidados);
        classificacaoFesta = view.findViewById(R.id.classificacao_festa);

        //Configurando o adapter e a listagem dos itens
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, cardViewNome);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Configuração do spinner do layout
        Spinner informacoesSpinner = view.findViewById(R.id.spinner_categoria);
        informacoesSpinner.setAdapter(adapter);


        informacoesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        editLocalFesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "toque", Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return view;

    }

}
