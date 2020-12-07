package mx.edu.utng.appinformativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario");
        setTitle("Usuario: "+ user);//Titulo de la Activity
    }

    public void continuar(View view) {
        Intent i = new Intent(this, NoticiaActivity.class);
        startActivity(i);
    }
}