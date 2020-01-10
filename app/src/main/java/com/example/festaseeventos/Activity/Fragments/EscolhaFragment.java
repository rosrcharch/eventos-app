package com.example.festaseeventos.Activity.Fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.example.festaseeventos.R;

public class EscolhaFragment extends Fragment {



    public EscolhaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_escolha, container, false);


        // Inflate the layout for this fragment
        return view;
    }

}
