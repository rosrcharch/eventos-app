package com.example.festaseeventos.Activity.Activity;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.festaseeventos.Activity.Fragments.EscolhaFragment;
import com.example.festaseeventos.Activity.Fragments.InformacoesFragment;
import com.example.festaseeventos.Activity.Fragments.ListaFragment;
import com.example.festaseeventos.Activity.Model.Servicos;
import com.example.festaseeventos.R;
import com.google.android.material.navigation.NavigationView;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.squareup.picasso.Picasso;

public class TelaCadastrarFesta extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;
    private ImageView tollbarImagem;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        //Configurando a Toolbar
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Minha Festa");
        setSupportActionBar(toolbar);

        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        viewPager = findViewById(R.id.viewPager);
        smartTabLayout = findViewById(R.id.viewPagertab);
        tollbarImagem = findViewById(R.id.toolbarImagem);
        navigationView = findViewById(R.id.navView);
        drawerLayout = findViewById(R.id.drawerLayout);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();


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

        Picasso.get()
                .load("https://observatoriog.bol.uol.com.br/wordpress/wp-content/uploads/2018/09/Festa-di-SantAnna-2015-Christmas-Edition-Lake-Como-Events-2.png")
                .into(tollbarImagem);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_inbox: {
                Toast.makeText(this, "menu imbox", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_starred: {
                Toast.makeText(this, "menu favoritos", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_sent_email: {
                Toast.makeText(this, "menu emails enviados", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_trash: {
                Toast.makeText(this, "menu lixeira", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_spam: {
                Toast.makeText(this, "menu spam", Toast.LENGTH_SHORT).show();
                break;
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
