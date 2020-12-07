package mx.edu.utng.appinformativa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NoticiaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se rlaciona con la vista
        setContentView(R.layout.activity_noticia);
        //Establece el titulo de la pantalla
        setTitle("Noticias");
    }

    //Método que realiza intent a la pantalla ListaNoticiaActivity
    public void noticias(View view) {
        Intent i = new Intent(this, ListaNoticiaActivity.class);
        startActivity(i);
    }
}