package com.example.tema4dam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tema4dam.teste.TestCovid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraficActivity extends AppCompatActivity {

    public static  final String KeyTransfer="transfer_key";
    List<TestCovid> testeCovid=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        testeCovid= (List<TestCovid>) getIntent().getSerializableExtra(KeyTransfer);
        Map<String,Integer> sursa=sursaGrafic(testeCovid);
        setContentView(new GraficView(getApplicationContext(),sursa));

    }

    private Map<String, Integer> sursaGrafic(List<TestCovid> testeCovid) {
        if(testeCovid==null||testeCovid.isEmpty()){
            return new HashMap<>();
        }
        Map<String,Integer> sursa=new HashMap<>();
        for(TestCovid testCovid:testeCovid){
            String cheie=testCovid.getRezultat();
            if(sursa.containsKey(cheie)){
                Integer valoare=sursa.get(cheie);
                sursa.put(cheie,valoare+1);

            }
            else{
                sursa.put(cheie,1);
            }
        }
        return sursa;
    }
}