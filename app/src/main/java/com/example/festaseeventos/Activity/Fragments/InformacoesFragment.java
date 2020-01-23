package com.example.festaseeventos.Activity.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.style.MaskFilterSpan;
import android.util.Log;
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

import com.example.festaseeventos.Activity.Model.Festa;
import com.example.festaseeventos.Activity.Model.Mask;
import com.example.festaseeventos.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InformacoesFragment extends Fragment {

    private Spinner spinnerCategoria;
    private EditText editLocalFesta;
    private EditText editData;
    private EditText editNumConvidados;
    private RatingBar classificacaoFesta;
    private Button botaoCriarFesta;
    private Festa festa;
    public String categoria;

    private String[] cardViewNome = new String[] {"Festa de aniversario", "Bodas", "Datas comemorativas",
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

        editData.addTextChangedListener(Mask.insert("##/##/####", editData));

        String pattern = "dd/mm/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        sdf.setLenient(true);

        //Configurando o adapter e a listagem dos itens
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, cardViewNome);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Configuração do spinner do layout
        final Spinner informacoesSpinner = view.findViewById(R.id.spinner_categoria);
        informacoesSpinner.setAdapter(adapter);

        //String data = editData.getText().toString();

      /*  try {
            Date date = sdf.parse(data);
        } catch (ParseException e) {
            Toast.makeText(getActivity(), "Insira uma data valida", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }*/

        informacoesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                categoria = informacoesSpinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

/*        editLocalFesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Escolha o local da sua festa", Toast.LENGTH_SHORT).show();
            }
        });*/

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
