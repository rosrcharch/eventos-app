package com.example.festaseeventos.Activity.di.CadastrarFestaDI;

import com.example.festaseeventos.Activity.Activity.TelaCadastrarFesta;

import dagger.Component;


@Component(modules = {FestaModulo.class})
public interface FestaComponent {

    void inject(TelaCadastrarFesta telaCadastrarFesta);

}
