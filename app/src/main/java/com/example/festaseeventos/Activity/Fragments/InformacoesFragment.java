package com.example.festaseeventos.Activity.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import com.example.festaseeventos.R;

public class InformacoesFragment extends Fragment {

    private Spinner informacoesSpinner;
    private ImageView informacoesImagens;

    public String[] cardViewNome = new String[] {"Festa de aniversario", "Bodas", "Datas comemorativas",
    "Casamento", "Corporativa", "Debutante", "Escolar", "Outros"};

    public int[] cardViewImg = {R.drawable.aniversario, R.drawable.bodas, R.drawable.datas_comemorativas,
     R.drawable.casamento, R.drawable.corporativa, R.drawable.debutante, R.drawable.escolar, R.drawable.outros};


    public InformacoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Configuração do spinner do layout
        informacoesSpinner = container.findViewById(R.id.spinner_categoria);

        //Configurando o adapter e a listagem dos itens
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cardViewNome);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        informacoesSpinner.setAdapter(adapter);


        informacoesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_informacoes, container, false);

    }


}
