package com.example.tema4dam.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tema4dam.GraficActivity;
import com.example.tema4dam.MainActivity;
import com.example.tema4dam.R;
import com.example.tema4dam.converter.JsonParser;
import com.example.tema4dam.converter.TesteAdapter;
import com.example.tema4dam.network.AsyncTaskRunner;
import com.example.tema4dam.network.Callback;
import com.example.tema4dam.network.HttpManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ListTeste extends AppCompatActivity {

    private final static String Url_Teste = "https://www.jsonkeeper.com/b/H7US";
    private AsyncTaskRunner asyncTaskRunner=new AsyncTaskRunner();

    private ListView lvTeste;
    private Button btnPreluareDate;
    private Button btnBack;
    private Button btnGrafic;

    private List<TestCovid> testCovidList=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_teste);

        initComponents();
    }

    private void initComponents() {
        lvTeste=findViewById(R.id.popescu_georgiana_lv_teste);
        testCovidList.add(new TestCovid(121,"rapid","negativ","Nu"));
        TesteAdapter adapter=new TesteAdapter(getApplicationContext(),R.layout.list_item_teste_lv,testCovidList,getLayoutInflater());
        //ArrayAdapter<TestCovid> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,testCovidList);
        lvTeste.setAdapter(adapter);
        btnPreluareDate=findViewById(R.id.popescu_georgiana_btn_preluareHttp);
        btnPreluareDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               loadFromHttp();
            }
        });
        btnBack=findViewById(R.id.popescu_georgiana_btn_back_test);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        btnGrafic=findViewById(R.id.popescu_georgiana_btn_test_grafic);
        btnGrafic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), GraficActivity.class);
                intent.putExtra(GraficActivity.KeyTransfer, (Serializable) testCovidList);
                startActivity(intent);
            }
        });
    }

    private void loadFromHttp() {
        Callable<String> asyncOperation=new HttpManager(Url_Teste);
        Callback<String> mainOperation=mainThreadOpeartion();
        asyncTaskRunner.executeAsync(asyncOperation,mainOperation);
    }

    private Callback<String> mainThreadOpeartion() {
        return new Callback<String>() {
            @Override
            public void runResultOnUiThread(String result) {
                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                testCovidList.addAll(JsonParser.fromJson(result));
                Toast.makeText(getApplicationContext(),String.valueOf(testCovidList.get(1)),Toast.LENGTH_SHORT).show();
                notifyAdapter();
            }
        };
    }

    private void notifyAdapter() {
        ArrayAdapter adapter= (ArrayAdapter) lvTeste.getAdapter();
        adapter.notifyDataSetChanged();
    }

}