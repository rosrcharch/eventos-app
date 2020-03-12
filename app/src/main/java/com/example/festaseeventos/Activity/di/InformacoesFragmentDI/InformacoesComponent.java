package com.example.festaseeventos.Activity.di.InformacoesFragmentDI;

import com.example.festaseeventos.Activity.Fragments.InformacoesFragment;

import dagger.Component;

@Component(modules = {InformacoesModulo.class})
public interface InformacoesComponent {

    void inject(InformacoesFragment informacoesFragment);
}
