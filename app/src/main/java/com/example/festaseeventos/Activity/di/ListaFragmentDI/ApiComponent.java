package com.example.festaseeventos.Activity.di.ListaFragmentDI;

import com.example.festaseeventos.Activity.Fragments.ListaFragment;

import dagger.Component;

@Component(modules = {ListaModulo.class})
public interface ApiComponent {

    void inject(ListaFragment listaFragment);

}
