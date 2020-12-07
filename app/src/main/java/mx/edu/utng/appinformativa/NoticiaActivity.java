package mx.edu.utng.appinformativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NoticiaActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);
        setTitle("Noticias");
    }
    public void noticias(View view) {
        Intent i = new Intent(this, ListaNoticiaActivity.class);
        startActivity(i);
    }
}