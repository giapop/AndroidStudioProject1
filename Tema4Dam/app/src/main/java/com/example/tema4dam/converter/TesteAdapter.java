package com.example.tema4dam.converter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.tema4dam.R;
import com.example.tema4dam.teste.TestCovid;

import java.util.List;

public class TesteAdapter extends ArrayAdapter<TestCovid> {

    private Context context;
    private int resource;
    private List<TestCovid> testCovids;
    private LayoutInflater inflater;
    public TesteAdapter(@NonNull Context context, int resource, @NonNull List<TestCovid> objects,LayoutInflater inflater) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.testCovids=objects;
        this.inflater=inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=inflater.inflate(resource,parent,false);
        TestCovid testCovid=testCovids.get(position);
        addCod(view,testCovid.getCodTest());
        addTip(view,testCovid.getTipTest());
        addRezultat(view,testCovid.getRezultat());
        return view;
    }

    private void addRezultat(View view, String rezultat) {
        TextView txt=view.findViewById(R.id.popescu_georgiana_lv_teste_txtView_rezultat);
        txt.setText(rezultat);
    }

    private void addTip(View view, String tipTest) {
        TextView txt=view.findViewById(R.id.popescu_georgiana_lv_teste_txtView_tip);
        txt.setText(tipTest);
    }

    private void addCod(View view, int codTest) {
        TextView txt=view.findViewById(R.id.popescu_georgiana_lv_teste_txtView_cod);
        txt.setText(context.getString(R.string.cod_lv,String.valueOf(codTest)));
    }
}
