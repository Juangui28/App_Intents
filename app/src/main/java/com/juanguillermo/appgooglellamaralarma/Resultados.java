package com.juanguillermo.appgooglellamaralarma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    String texto;
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        message = findViewById(R.id.Mensaje);

        Intent recibirDatos = getIntent();
        texto = recibirDatos.getStringExtra("Mensaje");
        message.setText(texto);
    }
}