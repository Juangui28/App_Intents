package com.juanguillermo.appgooglellamaralarma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button google,alarma,llamada,mapa,temporizador,pantalla;
    String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        google = findViewById(R.id.google);
        alarma = findViewById(R.id.alarma);
        llamada = findViewById(R.id.llamar);
        pantalla = findViewById(R.id.segundaPantalla);
        mapa = findViewById(R.id.mapa);
        temporizador = findViewById(R.id.temporizador);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToGoogle = new Intent(Intent.ACTION_VIEW);
                goToGoogle.setData(Uri.parse("http://www.google.com"));
                startActivity(goToGoogle);
            }
        });

        alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearAlarma();
            }
        });

        llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber("3215884456");
            }
        });

        pantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mensaje = "Esta es la segunda pantalla, bienvenido";
                Intent enviarDatos = new Intent(MainActivity.this,Resultados.class);
                enviarDatos.putExtra("Mensaje",mensaje);
                startActivity(enviarDatos);
            }
        });

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMap(Uri.parse("geo:6.2518400,-75.5635900"));
            }
        });

        temporizador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer("Ejercicio",90);
            }
        });

    }
    private void crearAlarma(){
        Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM);
        alarma.putExtra(AlarmClock.EXTRA_MESSAGE,"Gimnasio");
        alarma.putExtra(AlarmClock.EXTRA_HOUR,10);
        alarma.putExtra(AlarmClock.EXTRA_MINUTES,30);
        if(alarma.resolveActivity(getPackageManager())!=null){
            startActivity(alarma);
        }
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void startTimer(String message, int seconds) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}