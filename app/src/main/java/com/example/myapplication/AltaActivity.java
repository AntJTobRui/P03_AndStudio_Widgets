package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.util.GregorianCalendar;

public class AltaActivity extends AppCompatActivity {
    Persona pers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);

        pers = (Persona) getIntent().getSerializableExtra("objPers");
        Button butEnv = (Button) findViewById(R.id.butEnv);
        Button butCan = (Button) findViewById(R.id.butCancel);

        EditText edtxNom = (EditText) findViewById(R.id.textNomb);
        EditText edtxApe = (EditText) findViewById(R.id.textApe);
        EditText edtxFec = (EditText) findViewById(R.id.textFecNac);
        EditText edtxCur = (EditText) findViewById(R.id.textCurso);

        if(pers == null) {
            pers = new Persona();
        }else{
            edtxNom.setText(pers.getNombre());
            edtxApe.setText(pers.getApellido());
            edtxCur.setText(pers.getCurso());
            edtxFec.setText(Tools.gregorianCalendarToString(pers.getFecNac()));
        }

        butEnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(edtxNom.getText() != null && !edtxNom.getText().equals(""))
                pers.setNombre(String.valueOf(edtxNom.getText()));
                pers.setApellido(String.valueOf(edtxApe.getText()));
                GregorianCalendar gc = null;
                try {
                    //System.out.println(String.valueOf(edtxFec.getText()));
                    gc = Tools.stringToGregorianCalendar(String.valueOf(edtxFec.getText()));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                pers.setFecNac(gc);
                pers.setCurso(String.valueOf(edtxCur.getText()));
                Intent intent = new Intent(AltaActivity.this, SecondActivity.class);
                if (pers.getNombre()!=null && pers.getFecNac() != null && pers.getApellido() != null && pers.getCurso() != null) {
                    intent.putExtra("objPers", pers);
                    startActivity(intent);
                }else{
                    Toast toast1 = Toast.makeText(getApplicationContext(),
                                    "Rellena los datos", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        });

        butCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AltaActivity.this, SecondActivity.class);
                intent.putExtra("objPers", pers);
                startActivity(intent);
            }
        });
    }
}
