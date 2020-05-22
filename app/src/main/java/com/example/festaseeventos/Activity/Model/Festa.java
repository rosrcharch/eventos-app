package com.example.festaseeventos.Activity.Model;

import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;

public class Festa {

    @Inject
    public Festa() {
    }

    @SerializedName("tipo")
    private String tipoFesta;
    @SerializedName("local")
    private String localFesta;
    @SerializedName("data")
    private String dataFesta;
    @SerializedName("convidados")
    private String quantidadeConvidados;

    public String getTipoFesta() {
        return tipoFesta;
    }

    public void setTipoFesta(String tipoFesta) {
        this.tipoFesta = tipoFesta;
    }

    public String getLocalFesta() {
        return localFesta;
    }

    public void setLocalFesta(String localFesta) {
        this.localFesta = localFesta;
    }

    public String getDataFesta() {
        return dataFesta;
    }

    public void setDataFesta(String dataFesta) {
        this.dataFesta = dataFesta;
    }

    public String getQuantidadeConvidados() {
        return quantidadeConvidados;
    }

    public void setQuantidadeConvidados(String quantidadeConvidados) {
        this.quantidadeConvidados = quantidadeConvidados;
    }

    public float getClassificacaoFesta() {
        return ClassificacaoFesta;
    }

    public void setClassificacaoFesta(float classificacaoFesta) {
        ClassificacaoFesta = classificacaoFesta;
    }

    private float ClassificacaoFesta;


}
