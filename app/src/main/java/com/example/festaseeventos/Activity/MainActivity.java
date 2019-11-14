package com.example.festaseeventos.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.festaseeventos.R;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrarFesta;
    private Button btnCadastrarEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrarFesta = findViewById(R.id.btnCadastrarFesta);
        btnCadastrarEmpresa = findViewById(R.id.btnOferecerServico);

        //Configuração da statusBar translucida

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }


    public void cadastrarFesta(View view){

        startActivity(new Intent(this, TelaCadastrarFesta.class));

    }

    public void cadastrarEmpresa(View view){

        startActivity(new Intent(this, TelaOferecerServico.class));


    }
}
