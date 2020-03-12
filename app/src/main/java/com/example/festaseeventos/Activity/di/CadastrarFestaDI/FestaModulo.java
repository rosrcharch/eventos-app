package com.example.festaseeventos.Activity.di.CadastrarFestaDI;

import android.app.Activity;
import android.widget.ImageView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.festaseeventos.Activity.Fragments.EscolhaFragment;
import com.example.festaseeventos.Activity.Fragments.InformacoesFragment;
import com.example.festaseeventos.Activity.Fragments.ListaFragment;
import com.example.festaseeventos.R;
import com.google.android.material.navigation.NavigationView;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import dagger.Module;
import dagger.Provides;

@Module
public class FestaModulo {

    Activity activity;

    public FestaModulo(Activity activity){
        this.activity = activity;

    }

    @Provides
    public ViewPager viewPager(){
        return activity.findViewById(R.id.viewPager);
    }
    @Provides
    public SmartTabLayout smartTabLayout(){
        return activity.findViewById(R.id.viewPagertab);
    }
    @Provides
    public ImageView imageView(){
        return activity.findViewById(R.id.toolbarImagem);
    }
    @Provides
    public DrawerLayout drawerLayout(){
        return activity.findViewById(R.id.drawerLayout);
    }
    @Provides
    public NavigationView navigationView(){
        return activity.findViewById(R.id.navView);
    }


    @Provides
    public FragmentPagerItemAdapter fragmentPagerAdapter(){

        return  new FragmentPagerItemAdapter(
                ((FragmentActivity)activity).getSupportFragmentManager(),
                FragmentPagerItems.with(activity)
                        .add("Informações", InformacoesFragment.class)
                        .add("Lista", ListaFragment.class)
                        .add("Escolha", EscolhaFragment.class)
                        .create());
    }
}
