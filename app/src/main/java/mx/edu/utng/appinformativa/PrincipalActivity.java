package mx.edu.utng.appinformativa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se relaciona con la vista
        setContentView(R.layout.activity_principal);

        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario"); //Obtiene el nombre de ususario de la vista de login
        setTitle("Usuario: " + user); //Titulo de la Activity
    }

    //Realiza intent hacia la vista de NoticiaActivity
    public void continuar(View view) {
        Intent i = new Intent(this, NoticiaActivity.class);
        startActivity(i);
    }
}