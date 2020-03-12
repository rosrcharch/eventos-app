package com.example.festaseeventos.Activity.di.ListaFragmentDI;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.festaseeventos.Activity.Model.Servicos;
import com.example.festaseeventos.R;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class ListaModulo {

    View viewFragment;

    @Provides
    public RecyclerView recyclerView(){
        return viewFragment.findViewById(R.id.recycler_view);
    }

    public ListaModulo(View viewFragment){
        this.viewFragment = viewFragment;
    }

    @Provides
    public ArrayList<Servicos> criarServicos() {

        ArrayList<Servicos> listaServicos = new ArrayList<>();

        Servicos servicos = new Servicos("Bebidas");
        listaServicos.add(servicos);

        servicos = new Servicos("Decoração");
        listaServicos.add(servicos);

        servicos = new Servicos("Comidas");
        listaServicos.add(servicos);

        servicos = new Servicos("Convites");
        listaServicos.add(servicos);

        servicos = new Servicos("Garçon");
        listaServicos.add(servicos);

        servicos = new Servicos("DJ");
        listaServicos.add(servicos);

        servicos = new Servicos("Fotografia");
        listaServicos.add(servicos);

        servicos = new Servicos("Recreação");
        listaServicos.add(servicos);

        servicos = new Servicos("Brinquedos");
        listaServicos.add(servicos);

        servicos = new Servicos("Mágico");
        listaServicos.add(servicos);

        servicos = new Servicos("Recepsionista");
        listaServicos.add(servicos);

        servicos = new Servicos("Segurança");
        listaServicos.add(servicos);

        servicos = new Servicos("Stand up");
        listaServicos.add(servicos);

        servicos = new Servicos("Cantor/Banda");
        listaServicos.add(servicos);

        servicos = new Servicos("Karaokê");
        listaServicos.add(servicos);

        servicos = new Servicos("Barman");
        listaServicos.add(servicos);

        return listaServicos;
    }


}
