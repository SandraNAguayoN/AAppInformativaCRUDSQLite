package mx.edu.utng.appinformativa;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

public class ListaNoticiaActivity extends AppCompatActivity {
    FloatingActionButton fabUno;
    FloatingActionButton fabDos;
    FloatingActionButton fabTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_noticia);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //Se relaciona con la vista
        fabUno = (FloatingActionButton)findViewById(R.id.fab1);
        fabDos = (FloatingActionButton)findViewById(R.id.fab2);
        fabTres = (FloatingActionButton)findViewById(R.id.fab3);
        //Se maneja el evento onclick

        //FloatingActionButton fab = findViewById(R.id.fab);
        fabUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Para conectar con la otra actividad
                Intent intNuevo = new Intent(ListaNoticiaActivity.this, NuevaNoticiaActivity.class);
                startActivity(intNuevo); //Iniciar nueva actividad
                finish(); //Finaliza la activity actual (Main Activity)
            }
        });

        fabDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Para conectar con la otra actividad
                Intent intNuevo = new Intent(ListaNoticiaActivity.this, EditarNoticiaActivity.class);
                startActivity(intNuevo); //Iniciar nueva actividad
                finish(); //Finaliza la activity actual (Main Activity)
            }
        });

        fabTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Para conectar con la otra actividad
                Intent intNuevo = new Intent(ListaNoticiaActivity.this, EliminarNoticiaActivity.class);
                startActivity(intNuevo); //Iniciar nueva actividad
                finish(); //Finaliza la activity actual (Main Activity)
            }
        });
    }
}

