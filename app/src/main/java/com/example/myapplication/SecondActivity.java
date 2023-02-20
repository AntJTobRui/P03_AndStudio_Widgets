package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {
    Persona objt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Persona pers = (Persona) getIntent().getSerializableExtra("objPers");

        if (pers != null){
            objt=pers;
            //Comprobar datos de persona
            System.out.println(pers.getNombre());
            //Comprobar edad
            int ed = Tools.calculaEdad(pers.getFecNac());
            System.out.println("Edad: " + ed);
        }

        //Creo los botones del activity_second
        Button butAlta = (Button) findViewById(R.id.btnUno);
        Button butInfo = (Button) findViewById(R.id.btnCuatro);

        //Doy listeners a los botones
        butAlta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, AltaActivity.class);
                //Ejemplo para luego tratar las fechas y sacar la edad
                /*
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fec = "12/03/2021";
                try {
                    Date fecgc = sdf.parse(fec);
                    System.out.println(fecgc.toString());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }*/

                startActivity(intent);
            }
        });

        butInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, InfoActivity.class);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*TextView texto = (TextView) findViewById(R.id.textView2);

        if ((resultCode == RESULT_OK) && (requestCode == 12)) {
            texto.setText(data.getExtras().getCharSequence("DATO"));

            // Usamos data.getExtras() si la hija usa putExtra()
            // o data.getData() si la hija usa setData()


        } else {
            if (resultCode != RESULT_OK)
                texto.setText("No es ResultOK");
            else
                texto.setText("No es 11");
        }*/
    }



    public void pulsadoBoton(View v) {
        /*Intent data = new Intent();

        if (v instanceof Button)
            data.putExtra("DATO", ((Button) v).getText());
        else
            data.putExtra("DATO", "A saber qué has pulsado");

        setResult(RESULT_OK, data);
        finish();*/
    }
}