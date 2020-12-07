package mx.edu.utng.appinformativa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaNoticiaActivity extends AppCompatActivity {
    //Declara variables de botones flotantes
    FloatingActionButton fabUno;
    FloatingActionButton fabDos;
    FloatingActionButton fabTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se relaciona con la vista
        setContentView(R.layout.activity_lista_noticia);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //Asigna a variables el valor de los botones flotantes de la vista
        fabUno = (FloatingActionButton)findViewById(R.id.fab1);
        fabDos = (FloatingActionButton)findViewById(R.id.fab2);
        fabTres = (FloatingActionButton)findViewById(R.id.fab3);
        //Se maneja el evento onclick

        //Método para inciar intent cuando se de click en boton flotante
        //FloatingActionButton fab = findViewById(R.id.fab);
        fabUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Para conectar con la otra actividad
                Intent intNuevo = new Intent(ListaNoticiaActivity.this, NuevaNoticiaActivity.class);
                startActivity(intNuevo); //Iniciar nueva actividad
                finish(); //Finaliza la activity actual (ListaNoticiaActivity)
            }
        });

        //Método para inciar intent cuando se de click en boton flotante
        fabDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Para conectar con la otra actividad
                Intent intNuevo = new Intent(ListaNoticiaActivity.this, EditarNoticiaActivity.class);
                startActivity(intNuevo); //Iniciar nueva actividad
                finish(); //Finaliza la activity actual (ListaNoticiaActivity)
            }
        });

        //Método para inciar intent cuando se de click en boton flotante
        fabTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Para conectar con la otra actividad
                Intent intNuevo = new Intent(ListaNoticiaActivity.this, EliminarNoticiaActivity.class);
                startActivity(intNuevo); //Iniciar nueva actividad
                finish(); //Finaliza la activity actual (ListaNoticiaActivity)
            }
        });
    }
}

