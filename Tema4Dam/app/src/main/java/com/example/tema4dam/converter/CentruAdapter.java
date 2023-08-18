package com.example.tema4dam.converter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tema4dam.centre.CentruSanitar;
import com.example.tema4dam.R;

import java.util.List;

public class CentruAdapter extends ArrayAdapter<CentruSanitar> {
    private Context context;
    private int resource;
    private List<CentruSanitar> centruSanitars;
    private LayoutInflater inflater;
    public CentruAdapter(@NonNull Context context, int resource, @NonNull List<CentruSanitar> objects, LayoutInflater inflater) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.centruSanitars=objects;
        this.inflater=inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=inflater.inflate(resource,parent,false);
       CentruSanitar centruSanitar=centruSanitars.get(position);
       addJudet(view,centruSanitar.getJudet());
       addUnitate(view,centruSanitar.getDenumireUnitate());
       addDeschidere(view,centruSanitar.getOraDeschiere());
       addInchidere(view,centruSanitar.getOraInchidere());
        return view;
    }

    private void addInchidere(View view, int oraInchidere) {
        TextView txt=view.findViewById(R.id.popescu_georgiana_lv_txtView_oraInchidere);
        txt.setText(String.valueOf(oraInchidere));
    }

    private void addDeschidere(View view, int oraDeschiere) {
        TextView txt=view.findViewById(R.id.popescu_georgiana_lv_txtView_oraDeschidere);
        txt.setText(String.valueOf(oraDeschiere));
    }

    private void addUnitate(View view, String denumireUnitate) {
        TextView txt=view.findViewById(R.id.popescu_georgiana_lv_txtView_unitate);
        txt.setText(denumireUnitate);
    }

    private void addJudet(View view, String judet) {
        TextView txt=view.findViewById(R.id.popescu_georgiana_lv_txtView_judet);
        txt.setText(judet);
    }
}
