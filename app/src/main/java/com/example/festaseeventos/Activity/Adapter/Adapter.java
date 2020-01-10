package com.example.festaseeventos.Activity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.festaseeventos.Activity.Model.Convidado;
import com.example.festaseeventos.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Convidado> listaConvidados;

    public Adapter(List<Convidado> lista) {
        this.listaConvidados = lista;


    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Convidado convidado = listaConvidados.get(position);
        holder.convidados.setText(convidado.getNome());

    }

    @Override
    public int getItemCount() {
        return listaConvidados.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView convidados;
        ImageView imageConvidados;

        public MyViewHolder( View itemView) {
            super(itemView);

            convidados = itemView.findViewById(R.id.textViewConvidado);
/*
            imageConvidados = itemView.findViewById(R.id.imageViewConvidado);
*/
        }
    }
}
