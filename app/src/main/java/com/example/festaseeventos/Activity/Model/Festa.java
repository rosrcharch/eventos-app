package com.example.festaseeventos.Activity.Model;

import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import javax.inject.Inject;

public class Festa {

    @Inject
    public Festa() {
    }

    private Spinner tipoFesta;
    private EditText localFesta;
    private EditText dataFesta;
    private EditText quantidadeConvidados;
    private RatingBar ClassificacaoFesta;

    public EditText getDataFesta() {
        return dataFesta;
    }

    public void setDataFesta(EditText dataFesta) {
        this.dataFesta = dataFesta;
    }

    public Spinner getTipoFesta() {
        return tipoFesta;
    }

    public void setTipoFesta(Spinner tipoFesta) {
        this.tipoFesta = tipoFesta;
    }

    public EditText getLocalFesta() {
        return localFesta;
    }

    public void setLocalFesta(EditText localFesta) {
        this.localFesta = localFesta;
    }

    public EditText getQuantidadeConvidados() {
        return quantidadeConvidados;
    }

    public void setQuantidadeConvidados(EditText quantidadeConvidados) {
        this.quantidadeConvidados = quantidadeConvidados;
    }

    public RatingBar getClassificacaoFesta() {
        return ClassificacaoFesta;
    }

    public void setClassificacaoFesta(RatingBar classificacaoFesta) {
        ClassificacaoFesta = classificacaoFesta;
    }

}
