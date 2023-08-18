package com.example.tema4dam.centre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tema4dam.R;
import com.example.tema4dam.database.CentruSanitarService;
import com.example.tema4dam.network.Callback;
import com.google.android.material.textfield.TextInputEditText;

public class AddCentruSanitar extends AppCompatActivity {
    public static final String ADD_KEY = "ADD_KEY";
    private Intent intent;
    private Button btnSave;
    private TextInputEditText tyeJudet;
    private TextInputEditText tyeUnitate;
    private EditText editTextDeschidere;
    private EditText editTextInchidere;

    private CentruSanitarService centruSanitarService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_centru_sanitar);

        initComponents();
        centruSanitarService=new CentruSanitarService(getApplicationContext());
        intent=getIntent();
    }

    private void initComponents() {
        tyeJudet=findViewById(R.id.popescu_georgiana_tye_judet);
        tyeUnitate=findViewById(R.id.popescu_georgiana_tye_unitate);
        editTextDeschidere=findViewById(R.id.popescu_georgiana_edittxt_oraDeschidere);
        editTextInchidere=findViewById(R.id.popescu_georgiana_edittxt_oraInchidere);
        btnSave=findViewById(R.id.popescu_georgiana_btn_Save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isOk()){
                    CentruSanitar centruSanitar=buildCentru();
                    centruSanitarService.insert(centruSanitar,getInsertCallback());
                    intent.putExtra(ADD_KEY,centruSanitar);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    private Callback<CentruSanitar> getInsertCallback() {
      return new Callback<CentruSanitar>() {
          @Override
          public void runResultOnUiThread(CentruSanitar result) {
              Toast.makeText(getApplicationContext(), R.string.introdus,Toast.LENGTH_SHORT).show();
          }
      };
    }

    private CentruSanitar buildCentru() {
        String unitate=tyeUnitate.getText().toString();
        String judet=tyeJudet.getText().toString();
        int deschidere=Integer.parseInt(editTextDeschidere.getText().toString());
        int inchidere=Integer.parseInt(editTextInchidere.getText().toString());
        return new CentruSanitar(judet,unitate,deschidere,inchidere);
    }

    private boolean isOk() {
        if(tyeUnitate.getText()==null||tyeUnitate.getText().toString().trim().isEmpty()||tyeUnitate.getText().toString().length()<4){
            Toast.makeText(getApplicationContext(), R.string.caractere,Toast.LENGTH_SHORT).show();
            return false;
        }
        if(tyeJudet.getText()==null||tyeJudet.getText().toString().trim().isEmpty()||tyeJudet.getText().toString().length()<4){
            Toast.makeText(getApplicationContext(), R.string.caractere2,Toast.LENGTH_SHORT).show();
            return false;
        }

        if(editTextDeschidere.getText()==null||editTextDeschidere.getText().toString().trim().isEmpty()||Integer.parseInt(editTextDeschidere.getText().toString().trim())<7){
            Toast.makeText(getApplicationContext(), R.string.ora1,Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editTextInchidere.getText()==null||editTextInchidere.getText().toString().trim().isEmpty()||Integer.parseInt(editTextInchidere.getText().toString().trim())>22){
            Toast.makeText(getApplicationContext(), R.string.ora2,Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}