package com.example.festaseeventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrarFesta;
    private Button btnCadastrarEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrarFesta = findViewById(R.id.btnCadastrarFesta);
        btnCadastrarEmpresa = findViewById(R.id.btnOferecerServico);
    }


    public void cadastrarFesta(View view){

        startActivity(new Intent(this, TelaCadastrarFesta.class));

    }

    public void cadastrarEmpresa(View view){

        startActivity(new Intent(this, TelaOferecerServico.class));


    }
}
