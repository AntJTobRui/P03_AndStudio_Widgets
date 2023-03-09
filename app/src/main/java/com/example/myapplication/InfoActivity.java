package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
public class InfoActivity extends AppCompatActivity{
    Persona objt;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Persona pers = (Persona) getIntent().getSerializableExtra("objPers");
        if(pers != null && pers.getNombre() != null)
            this.objt = pers;
        Button butVol = (Button) findViewById(R.id.butVolver);

        EditText edtxNom = (EditText) findViewById(R.id.textNomb);
        EditText edtxApe = (EditText) findViewById(R.id.textApe);
        EditText edtxEd = (EditText) findViewById(R.id.textEdad);
        EditText edtxCur = (EditText) findViewById(R.id.textCurso);

        if (pers != null){
            edtxNom.setText(objt.getNombre());
            edtxApe.setText(objt.getApellido());
            edtxEd.setText(""+Tools.calculaEdad(objt.getFecNac()));
            edtxCur.setText(objt.getCurso());
        }

        butVol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = getIntent(); //sirve?
                Intent intent = new Intent(InfoActivity.this, SecondActivity.class);
                if (pers.getNombre()!=null && pers.getFecNac() != null && pers.getApellido() != null && pers.getCurso() != null)
                    intent.putExtra("objPers", pers);
                startActivity(intent);
            }
        });
    }
}
