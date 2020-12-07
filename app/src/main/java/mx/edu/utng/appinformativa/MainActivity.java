package mx.edu.utng.appinformativa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se relaciona con la vista
        setContentView(R.layout.activity_main);
        //Estabece titulo de ña pantañña
        setTitle("noticeMe!");

        //Relacionar
        ImageView imagen = (ImageView) findViewById(R.id.animacion);
        //Se relaciona con el XML que tiene definido
        Animation animacion = AnimationUtils.loadAnimation(this,R.anim.animacion);
        //Se inicia la animación
        imagen.startAnimation(animacion);
    }

    //Metodo que realiza un intent para navegar hacia la pantalla del login
    public void inicio(View view) {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }
}

