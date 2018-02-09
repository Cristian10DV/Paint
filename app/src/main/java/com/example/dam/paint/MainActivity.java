package com.example.dam.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_main);
        //setContentView(new VistaPintada(this));

        Button btCirculos = findViewById(R.id.btCirculos);

        btCirculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);
                PintarCirculo fondo = new PintarCirculo(MainActivity.this);
                rl1.addView(fondo);
            }
        });

        Button btPincel = findViewById(R.id.btPincel);

        btPincel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);
                VistaPintada fondo = new VistaPintada(MainActivity.this);
                rl1.addView(fondo);
            }
        });

        Button btLineas = findViewById(R.id.btLineas);

        btLineas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);
                PintarRectas fondo = new PintarRectas(MainActivity.this);
                rl1.addView(fondo);
            }
        });

        Button btLimpiar = findViewById(R.id.btLimpiar);

        btLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);
                Limpiar fondo = new Limpiar(MainActivity.this);
                rl1.addView(fondo);
            }
        });

        Button btBorrar = findViewById(R.id.btBorrar);

        btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);
                Borrar fondo = new Borrar(MainActivity.this);
                rl1.addView(fondo);
            }
        });

        Button btRojo = findViewById(R.id.btRojo);

        btRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);
                Rojo fondo = new Rojo(MainActivity.this);
                rl1.addView(fondo);
            }
        });

        Button btAzul = findViewById(R.id.btAzul);

        btAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);
                Azul fondo = new Azul(MainActivity.this);
                rl1.addView(fondo);
            }
        });

        Button btVerde = findViewById(R.id.btVerde);

        btVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);
                Verde fondo = new Verde(MainActivity.this);
                rl1.addView(fondo);
            }
        });

    }
}
