package com.example.festaseeventos.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;

import com.example.festaseeventos.Activity.Fragments.EscolhaFragment;
import com.example.festaseeventos.Activity.Fragments.InformacoesFragment;
import com.example.festaseeventos.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class TelaCadastrarFesta extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_festa);

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
                .add("Lista", ListFragment.class)
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
    }
}
