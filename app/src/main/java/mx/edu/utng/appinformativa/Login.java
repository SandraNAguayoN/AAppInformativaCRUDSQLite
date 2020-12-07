package mx.edu.utng.appinformativa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener{

    //Declara variables para los elementos del login
    EditText etUser, etPass;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Relacionar con la vista de XML
        setContentView(R.layout.activity_login);
        //Establece titulo de pantalla
        setTitle("Iniciar Sesión");

        //Asigna valor a variables de los eementos de la vista por id
        etUser = (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        //Asociar escucha
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        //Declarar variables para obtener usuario y password
        String user = etUser.getText().toString();
        String pass = etPass.getText().toString();

        if (!user.isEmpty() && !pass.isEmpty()) { //Evalua que los campos no estén vacios
            //se asocian las pantallas
            Intent intentLogin = new Intent(Login.this, PrincipalActivity.class);
            intentLogin.putExtra("Usuario", user); //Se envia un parámetro
            //Se inicia la otra Activity
            startActivity(intentLogin);
        } else {
            Intent intentLogin = new Intent(Login.this, ErrorLogin.class);
            intentLogin.putExtra("Usuario", user); //Se envia un parámetro
            intentLogin.putExtra("password", pass);
            Toast.makeText(Login.this, "Error datos vacíos!", Toast.LENGTH_LONG).show();
        }
    }
}