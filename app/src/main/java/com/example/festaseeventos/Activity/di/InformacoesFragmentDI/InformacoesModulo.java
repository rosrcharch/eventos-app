package com.example.festaseeventos.Activity.di.InformacoesFragmentDI;

import android.app.Activity;
import android.widget.EditText;

import com.example.festaseeventos.R;

import dagger.Module;
import dagger.Provides;

@Module
public class InformacoesModulo {

    @Provides
    public String[] cardViewNome(){

        return new String[] {"Categoria", "Festa de aniversario", "Bodas", "Datas comemorativas",
                "Casamento", "Corporativa", "Debutante", "Escolar", "Outros"};

    }
}
