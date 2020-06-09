package com.example.festaseeventos.Activity.Fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.festaseeventos.Activity.Model.Festa;
import com.example.festaseeventos.Activity.Model.Mask;
import com.example.festaseeventos.Activity.api.FestaApi;

import com.example.festaseeventos.Activity.di.InformacoesFragmentDI.DaggerInformacoesComponent;
import com.example.festaseeventos.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InformacoesFragment extends Fragment {

    private Button botaoCriarFesta;
    private String categoria;
    private EditText editData;
    private EditText editLocalFesta;
    private EditText editNumConvidados;
    private RatingBar classificacaoFesta;
    @Inject
    Festa novaFesta;
    @Inject
    String[] cardViewNome;
    @Inject
    FestaApi api;

    // Required empty public constructor
    public InformacoesFragment() {

        DaggerInformacoesComponent.create().inject(this);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_informacoes, container, false);
        botaoCriarFesta = view.findViewById(R.id.buttonCriarFesta);
        editNumConvidados = view.findViewById(R.id.edit_num_convidados);
        editLocalFesta = view.findViewById(R.id.edit_local_festa);
        classificacaoFesta = view.findViewById(R.id.classificacao_festa);


        //mascara de testo para formação de data
        editData = view.findViewById(R.id.edit_data);
        editData.addTextChangedListener(Mask.insert("##/##/####", editData));


        //Configurando o adapter e a listagem dos itens
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.select_dialog_item, cardViewNome);
        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);

        //Configuração do spinner do layout
        final Spinner spinner = view.findViewById(R.id.spinner_categoria);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position > 0){
                categoria = spinner.getSelectedItem().toString();
                }else {
                    Toast.makeText(getContext(), "Nenhuma categoria selecionada", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        botaoCriarFesta.setOnClickListener((v) -> {


            if (editData.getText().toString().isEmpty()){
                Toast.makeText(getActivity(), "Isira uma data", Toast.LENGTH_SHORT).show();
            }else if (editLocalFesta.getText().toString().isEmpty()){
                Toast.makeText(getActivity(), "Insira um local de festa", Toast.LENGTH_SHORT).show();
            }else if (editNumConvidados.getText().toString().isEmpty()){
                Toast.makeText(getActivity(), "Isira um numero de convidados", Toast.LENGTH_SHORT).show();
            }else {

                novaFesta.setTipoFesta(categoria);
                novaFesta.setLocalFesta(editLocalFesta.getText().toString());
                novaFesta.setDataFesta(editData.getText().toString());
                novaFesta.setQuantidadeConvidados(editNumConvidados.getText().toString());

                setFesta();
                EscolhaFragment.num++;

                Log.d("num", "onCreateView: " + EscolhaFragment.num);


                //Toast.makeText(getActivity(), "Festa Salvada", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "festa salva:  "
                        + "Categoria: " + categoria + "\n"
                        + "Local: " + editLocalFesta.getText().toString() + "\n"
                        + "DATA: " + editData.getText().toString() + "\n"
                        + "Numero de convidados: " + editNumConvidados.getText().toString() + "\n"
                        + "Sua classificação: " + classificacaoFesta.getRating(), Toast.LENGTH_LONG).show();

            }


        });


        // Inflate the layout for this fragment
        return view;

    }

    public void setFesta(){

        Call<Festa> call = api.setListaFesta(novaFesta);
        call.enqueue(new Callback<Festa>() {
            @Override
            public void onResponse(Call<Festa> call, Response<Festa> response) {
                novaFesta = response.body();

            }

            @Override
            public void onFailure(Call<Festa> call, Throwable t) {

            }
        });




    }


}
