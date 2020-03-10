package com.example.festaseeventos.Activity.Fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.festaseeventos.Activity.Model.Festa;
import com.example.festaseeventos.Activity.Model.Mask;
import com.example.festaseeventos.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.text.SimpleDateFormat;

public class InformacoesFragment extends Fragment {


    private Spinner spinnerCategoria;
    private EditText editLocalFesta;
    private EditText editData;
    private EditText editNumConvidados;
    private RatingBar classificacaoFesta;
    private Button botaoCriarFesta;
    private Festa festa;
    private String categoria;



    public String[] cardViewNome = new String[] {"Categoria", "Festa de aniversario", "Bodas", "Datas comemorativas",
            "Casamento", "Corporativa", "Debutante", "Escolar", "Outros"};



    // Required empty public constructor
    public InformacoesFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_informacoes, container, false);


        editLocalFesta = view.findViewById(R.id.edit_local_festa);
        editData = view.findViewById(R.id.edit_data);
        editNumConvidados = view.findViewById(R.id.edit_num_convidados);
        classificacaoFesta = view.findViewById(R.id.classificacao_festa);
        botaoCriarFesta = view.findViewById(R.id.buttonCriarFesta);
        spinnerCategoria = view.findViewById(R.id.spinner_categoria);


        //mascara de testo para formação de data
        editData.addTextChangedListener(Mask.insert("##/##/####", editData));

        //Validador de data, nao funcional
        String pattern = "dd/mm/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        sdf.setLenient(true);


        //Configurando o adapter e a listagem dos itens
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.select_dialog_item, cardViewNome);
        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);

        //Configuração do spinner do layout
        final Spinner informacoesSpinner = view.findViewById(R.id.spinner_categoria);
        informacoesSpinner.setAdapter(adapter);


        informacoesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position > 0){
                categoria = informacoesSpinner.getSelectedItem().toString();
                }else {
                    Toast.makeText(getContext(), "Nenhuma categoria selecionada", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        botaoCriarFesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Festa novaFesta = new Festa();
                novaFesta.setDataFesta(editData);
                novaFesta.setLocalFesta(editLocalFesta);
                novaFesta.setQuantidadeConvidados(editNumConvidados);
                novaFesta.setClassificacaoFesta(classificacaoFesta);
                novaFesta.setTipoFesta(spinnerCategoria);

                Log.d("Data: ", novaFesta.getDataFesta().getText().toString());

                if (editData.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Isira uma data", Toast.LENGTH_SHORT).show();
                }else if (editLocalFesta.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Insira um local de festa", Toast.LENGTH_SHORT).show();
                }else if (editNumConvidados.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Isira um numero de convidados", Toast.LENGTH_SHORT).show();
                }else if (spinnerCategoria == null) {
                    Toast.makeText(getActivity(), "Categoria vazia", Toast.LENGTH_SHORT).show();
                }else {

                    //Toast.makeText(getActivity(), "Festa Salvada", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getActivity(), "festa salva:  "
                            + "Categoria: " + categoria + "\n"
                            + "Local: " + editLocalFesta.getText().toString() + "\n"
                            + "DATA: " + editData.getText().toString() + "\n"
                            + "Numero de convidados: " + editNumConvidados.getText().toString() + "\n"
                            + "Sua classificação: " + classificacaoFesta.getRating(), Toast.LENGTH_LONG).show();
                }

            }
        });

        // Inflate the layout for this fragment
        return view;

    }

}
