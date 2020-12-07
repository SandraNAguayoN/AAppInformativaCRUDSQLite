package mx.edu.utng.appinformativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("noticeMe!");

        //Relacionar
        ImageView imagen = (ImageView) findViewById(R.id.animacion);
        //Se relaciona con el XML que tiene definido
        Animation animacion = AnimationUtils.loadAnimation(this,R.anim.animacion);
        //Se inicia la animación
        imagen.startAnimation(animacion);

}


    public void inicio(View view) {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }
    }

