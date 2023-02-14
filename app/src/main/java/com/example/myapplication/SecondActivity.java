package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Creo los botones del activity_second
        Button butUno = (Button) findViewById(R.id.btnUno);

        //Doy listeners a los botones
        butUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, AltaActivity.class);
                /** Llamada a la hija con startActivityForResult() nos               *
                 *  obliga a sobreescribir onActivityResult(), más abajo.            *
                 *  Se podría llamar con startActivity() si la hija no devuelve nada */

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