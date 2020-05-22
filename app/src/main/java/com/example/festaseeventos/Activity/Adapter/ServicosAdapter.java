package com.example.festaseeventos.Activity.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.festaseeventos.Activity.Interface.RecyclerViewOnItemClick;
import com.example.festaseeventos.Activity.Model.Servicos;
import com.example.festaseeventos.R;

import java.util.ArrayList;
import java.util.List;

public class ServicosAdapter extends RecyclerView.Adapter<ServicosAdapter.MyViewHolder> {

    public static ArrayList<Servicos> listaServiço;
    private Context context;
    private RecyclerViewOnItemClick mRecyclerViewOnItemClick;


    public ServicosAdapter(ArrayList<Servicos> lista, Context context) {
        this.listaServiço = lista;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        Servicos servicos = listaServiço.get(position);
        holder.servico.setText(servicos.getNome());
        holder.dropLayout(listaServiço.get(position));
        holder.checkSwhitch(listaServiço.get(position));
        holder.ifTable(listaServiço.get(position));

    }

    @Override
    public int getItemCount() {
        return listaServiço.size();
    }


    public void setRecyclerViewOnItemClick(RecyclerViewOnItemClick r){
        mRecyclerViewOnItemClick = r;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements OnClickListener{

        TextView servico;
        ImageView btnOpcao;
        SwitchCompat shwOpcao;
        LinearLayout linOpcao;
        EditText edtOpcao;
        CheckBox rbOpcao1, rbOpcao2, rbOpcao3, rbOpcao4, rbOpcao5, rbOpcao6, rbOpcao7;

        public MyViewHolder( View itemView) {
            super(itemView);

            servico = itemView.findViewById(R.id.textViewServico);
            btnOpcao = itemView.findViewById(R.id.buttonOpcoes);
            shwOpcao = itemView.findViewById(R.id.switchOpcao);
            linOpcao = itemView.findViewById(R.id.linearImage);
            rbOpcao1 = itemView.findViewById(R.id.rbOpcao1);
            rbOpcao2 = itemView.findViewById(R.id.rbOpcao2);
            rbOpcao3 = itemView.findViewById(R.id.rbOpcao3);
            rbOpcao4 = itemView.findViewById(R.id.rbOpcao4);
            rbOpcao5 = itemView.findViewById(R.id.rbOpcao5);
            rbOpcao6 = itemView.findViewById(R.id.rbOpcao6);
            rbOpcao7 = itemView.findViewById(R.id.rbOpcao7);
            edtOpcao = itemView.findViewById(R.id.edtOpcao);

            btnOpcao.setOnClickListener(this);
            /*itemView.setOnLongClickListener(this);*/

        }

        public void dropLayout(Servicos servicos){

            if (servicos.isEhClicado()){
                btnOpcao.setImageResource(R.drawable.ic_play);
                linOpcao.setVisibility(View.GONE);
            }else {
                btnOpcao.setImageResource(R.drawable.drop);
                linOpcao.setVisibility(View.VISIBLE);
            }

        }

        public void checkSwhitch(final Servicos servicos){

            shwOpcao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Toast.makeText(context, "ligado", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(context, "desligado", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }

       /* public Dialog dialogDelete(){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Deseja deletar o item selecionado?")
                    .setPositiveButton("Sim", (dialog, which) -> {

                        listaServiço.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());

                    })
                    .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

            return builder.create();
        }*/

        public void ifTable(Servicos servicos){


            if (getAdapterPosition()==0){

                rbOpcao1.setText("Refrigerantes");
                rbOpcao2.setText("Sucos");
                rbOpcao3.setText("Cerveja");
                rbOpcao4.setText("Destilados");
                rbOpcao5.setText("Outros");
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setVisibility(View.GONE);

            }else if (getAdapterPosition()==1){

                rbOpcao1.setVisibility(View.GONE);
                rbOpcao2.setVisibility(View.GONE);
                rbOpcao3.setVisibility(View.GONE);
                rbOpcao4.setVisibility(View.GONE);
                rbOpcao5.setVisibility(View.GONE);
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setHint("Qual tema?");

            }else if (getAdapterPosition()==2){

                rbOpcao1.setText("Salgados");
                rbOpcao2.setText("Refeição");
                rbOpcao3.setText("Churrasco");
                rbOpcao4.setText("Crep");
                rbOpcao5.setText("Sobremesa");
                rbOpcao6.setText("Cozinha vegana");
                rbOpcao7.setText("Outros");
                edtOpcao.setHint("Observações");

            }else if (getAdapterPosition()==3){

                rbOpcao1.setText("Fisico (em papel)");
                rbOpcao2.setText("Virtual estático");
                rbOpcao3.setText("Virtual vídeo");
                rbOpcao4.setVisibility(View.GONE);
                rbOpcao5.setVisibility(View.GONE);
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setHint("Observações");

            }else if (getAdapterPosition()==4){

                rbOpcao1.setVisibility(View.GONE);
                rbOpcao2.setVisibility(View.GONE);
                rbOpcao3.setVisibility(View.GONE);
                rbOpcao4.setVisibility(View.GONE);
                rbOpcao5.setVisibility(View.GONE);
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setHint("Quantos garçoes");

            }else if (getAdapterPosition()==5){

                rbOpcao1.setVisibility(View.GONE);
                rbOpcao2.setVisibility(View.GONE);
                rbOpcao3.setVisibility(View.GONE);
                rbOpcao4.setVisibility(View.GONE);
                rbOpcao5.setVisibility(View.GONE);
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setHint("Quantos DJ");

            }else if (getAdapterPosition()==6){

                rbOpcao1.setVisibility(View.GONE);
                rbOpcao2.setVisibility(View.GONE);
                rbOpcao3.setVisibility(View.GONE);
                rbOpcao4.setVisibility(View.GONE);
                rbOpcao5.setVisibility(View.GONE);
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setHint("Quantos fotografos?");

            }else if (getAdapterPosition()==7){

                rbOpcao1.setVisibility(View.GONE);
                rbOpcao2.setVisibility(View.GONE);
                rbOpcao3.setVisibility(View.GONE);
                rbOpcao4.setVisibility(View.GONE);
                rbOpcao5.setVisibility(View.GONE);
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setHint("Observação?");

            }else if (getAdapterPosition()==8){

                rbOpcao1.setVisibility(View.GONE);
                rbOpcao2.setVisibility(View.GONE);
                rbOpcao3.setVisibility(View.GONE);
                rbOpcao4.setVisibility(View.GONE);
                rbOpcao5.setVisibility(View.GONE);
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setHint("Observação?");

            }else if (getAdapterPosition()==9){

                rbOpcao1.setVisibility(View.GONE);
                rbOpcao2.setVisibility(View.GONE);
                rbOpcao3.setVisibility(View.GONE);
                rbOpcao4.setVisibility(View.GONE);
                rbOpcao5.setVisibility(View.GONE);
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setHint("Observação?");
            }else if (getAdapterPosition()==10){

                rbOpcao1.setVisibility(View.GONE);
                rbOpcao2.setVisibility(View.GONE);
                rbOpcao3.setVisibility(View.GONE);
                rbOpcao4.setVisibility(View.GONE);
                rbOpcao5.setVisibility(View.GONE);
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setHint("Observação?");

            }else if (getAdapterPosition()==11){

                rbOpcao1.setVisibility(View.GONE);
                rbOpcao2.setVisibility(View.GONE);
                rbOpcao3.setVisibility(View.GONE);
                rbOpcao4.setVisibility(View.GONE);
                rbOpcao5.setVisibility(View.GONE);
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setHint("Observação?");

            }else if (getAdapterPosition()==12){

                rbOpcao1.setVisibility(View.GONE);
                rbOpcao2.setVisibility(View.GONE);
                rbOpcao3.setVisibility(View.GONE);
                rbOpcao4.setVisibility(View.GONE);
                rbOpcao5.setVisibility(View.GONE);
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setHint("Observação?");

            }else if (getAdapterPosition()==13){

                rbOpcao1.setVisibility(View.GONE);
                rbOpcao2.setVisibility(View.GONE);
                rbOpcao3.setVisibility(View.GONE);
                rbOpcao4.setVisibility(View.GONE);
                rbOpcao5.setVisibility(View.GONE);
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setHint("Observação?");

            }else if (getAdapterPosition()==14){

                rbOpcao1.setVisibility(View.GONE);
                rbOpcao2.setVisibility(View.GONE);
                rbOpcao3.setVisibility(View.GONE);
                rbOpcao4.setVisibility(View.GONE);
                rbOpcao5.setVisibility(View.GONE);
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setHint("Observação?");

            }else if (getAdapterPosition()>= 15){

                rbOpcao1.setVisibility(View.GONE);
                rbOpcao2.setVisibility(View.GONE);
                rbOpcao3.setVisibility(View.GONE);
                rbOpcao4.setVisibility(View.GONE);
                rbOpcao5.setVisibility(View.GONE);
                rbOpcao6.setVisibility(View.GONE);
                rbOpcao7.setVisibility(View.GONE);
                edtOpcao.setHint("Observação?");
            }
        }

        @Override
        public void onClick(View v) {

            if (mRecyclerViewOnItemClick != null){
                mRecyclerViewOnItemClick.onClickListener(v, getAdapterPosition());

                Servicos servicos = listaServiço.get(getAdapterPosition());
                servicos.setEhClicado(!servicos.isEhClicado());

                dropLayout(servicos);
                if (shwOpcao.isChecked() == false){
                    shwOpcao.setChecked(true);
                }


            }

        }

       /* @Override
        public boolean onLongClick(View v) {
                *//*dialogDelete().show();*//*
                Toast.makeText(context, "click longo ", Toast.LENGTH_SHORT).show();

            return true;
        }*/


    }



}