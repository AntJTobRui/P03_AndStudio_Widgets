package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.io.Serializable;

public class WidUnoActivity extends AppCompatActivity {

    private Button btnAcep;
    Button btnSal;
    private CheckBox checkRepeti;
    private CheckBox checkNoRep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widuno);

        Persona pers;
        pers = (Persona) getIntent().getSerializableExtra("objPers");

        checkRepeti = (CheckBox) findViewById(R.id.checkBoxEmpleado);
        checkNoRep = (CheckBox) findViewById(R.id.checkBoxParo);
        btnAcep = (Button) findViewById(R.id.buttonAceptarW1);
        btnSal =  (Button) findViewById(R.id.buttonSalirW1);

        btnAcep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pers != null) {
                    if (checkRepeti.isChecked()) {
                        pers.setRepite(true);
                    }

                    if (checkNoRep.isChecked()) {
                        pers.setRepite(false);
                    }
                }

                Intent intent = new Intent(WidUnoActivity.this, SecondActivity.class);
                intent.putExtra("objPers", (Serializable) pers);
                startActivity(intent);

            }
        });

        btnSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WidUnoActivity.this,SecondActivity.class);
                intent.putExtra("objPers", (Serializable) pers);
                startActivity(intent);

            }
        });

    }
}
