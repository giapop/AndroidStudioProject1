package com.example.tema4dam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.tema4dam.centre.ListCentre;
import com.example.tema4dam.teste.ListTeste;

public class MainActivity extends AppCompatActivity {


    private Button btnListaCentre;
    private Button btnListaTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

    }

    private void initComponents() {
      btnListaCentre=findViewById(R.id.popescu_georgiana_btn_ListaCentre);
      btnListaCentre.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(getApplicationContext(), ListCentre.class);
              startActivity(intent);
          }
      });
      btnListaTeste=findViewById(R.id.popescu_georgiana_btn_ListaTesteCovid);
      btnListaTeste.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(getApplicationContext(), ListTeste.class);
              startActivity(intent);
          }
      });
    }



}
