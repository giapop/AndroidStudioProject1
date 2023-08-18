package com.example.tema4dam.centre;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.tema4dam.MainActivity;
import com.example.tema4dam.R;
import com.example.tema4dam.converter.CentruAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListCentre extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher;
    private List<CentruSanitar> centruSanitarList=new ArrayList<>();
   private Button btnAdaugaCentru;
   private ListView lvCentre;
   private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_centre);
        initComponents();
        launcher=openLauncher();
    }

    private ActivityResultLauncher<Intent> openLauncher() {
        ActivityResultCallback<ActivityResult> callback=getCallback();
        return registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),callback);
    }
    private ActivityResultCallback<ActivityResult> getCallback(){
        return  new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode()==RESULT_OK &&result.getData()!=null){
                    CentruSanitar centruSanitar= (CentruSanitar) result.getData().getSerializableExtra(AddCentruSanitar.ADD_KEY);
                    if(centruSanitar!=null){
                        centruSanitarList.add(centruSanitar);
                        notifyAdapter();
                    }

                }
            }
        };
    }

    private void notifyAdapter() {
        ArrayAdapter adapter= (ArrayAdapter) lvCentre.getAdapter();
        adapter.notifyDataSetChanged();
    }

    private void initComponents() {
        lvCentre=findViewById(R.id.popescu_georgiana_lv_centre);
        CentruSanitar centruSanitar=new CentruSanitar("Judet1","Denumire1",10,21);
        centruSanitarList.add(centruSanitar);
        //ArrayAdapter<CentruSanitar> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,centruSanitarList);
        CentruAdapter adapter=new CentruAdapter(getApplicationContext(),R.layout.list_item_add,centruSanitarList,getLayoutInflater());
        lvCentre.setAdapter(adapter);
        btnAdaugaCentru=findViewById(R.id.popescu_georgiana_btn_AdaugaCentru);
        btnAdaugaCentru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),AddCentruSanitar.class);
                launcher.launch(intent);
            }
        });
        btnBack=findViewById(R.id.popescu_georgiana_btn_back_centru);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}