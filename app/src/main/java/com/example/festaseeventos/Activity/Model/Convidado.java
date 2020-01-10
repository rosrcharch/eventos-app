package com.example.festaseeventos.Activity.Model;

public class Convidado {

    public Convidado(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;

    public Convidado(String nome) {
        this.nome = nome;
    }
}
