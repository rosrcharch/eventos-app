package com.example.festaseeventos.Activity.Model;


import javax.inject.Inject;

public class Servicos {

    private String nome;
    private boolean ehClicado = true;

    @Inject
    public Servicos(){

    }

    public boolean isEhClicado() {
        return ehClicado;
    }

    public void setEhClicado(boolean ehClicadoBebidas) {
        this.ehClicado = ehClicadoBebidas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Servicos(String nome) {
        this.nome = nome;
    }
}
