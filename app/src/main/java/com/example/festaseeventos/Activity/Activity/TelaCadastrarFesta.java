package com.example.festaseeventos.Activity.Activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.festaseeventos.Activity.Fragments.EscolhaFragment;
import com.example.festaseeventos.Activity.Fragments.InformacoesFragment;
import com.example.festaseeventos.Activity.Fragments.ListaFragment;
import com.example.festaseeventos.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class TelaCadastrarFesta extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;

    public String[] cardViewNome = new String[] {"Festa de aniversario", "Bodas", "Datas comemorativas",
            "Casamento", "Corporativa", "Debutante", "Escolar", "Outros"};

    //public int[] cardViewImg = {R.drawable.aniversario, R.drawable.bodas, R.drawable.datas_comemorativas,
    // R.drawable.casamento, R.drawable.corporativa, R.drawable.debutante, R.drawable.escolar, R.drawable.outros};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_festa);

        //Configurando a Toolbar
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Minha Festa");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewPager);
        smartTabLayout = findViewById(R.id.viewPagertab);

        //Configuração as abas da tela Cadastrar Festas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                .add("Informações", InformacoesFragment.class)
                .add("Lista", ListaFragment.class)
                .add("Escolha", EscolhaFragment.class)
                .create()
        );
        viewPager.setAdapter( adapter );
        smartTabLayout.setViewPager( viewPager );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
/*
        super.onCreateOptionsMenu(menu);
        MenuItem m1 = menu.add(R.menu.toolbar_menu, 0, 0, "menu 1");
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        MenuItem m2 = menu.add(R.menu.convidados_menu, 0, 0, "menu convidados");
        m2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return super.onCreateOptionsMenu(menu);*/
    }

}
