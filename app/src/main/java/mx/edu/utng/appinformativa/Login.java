package mx.edu.utng.appinformativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{

    EditText etUser, etPass;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Iniciar Sesión");
        //Relacionar con la vista de XML
        etUser = (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        //Asociar escucha
        btnLogin.setOnClickListener(this);
    }

    //Suponer que el usuario es utng y la contraseña es utng2020 datos fijos
    //En caso de ser correctos mostrar el ListView de versiones
    //En caso contrario mostrar otro Activity que muestre:
    //Usuario: Juan xxxx
    //Password: 123 xxx
    //INCORRECTOS

    @Override
    public void onClick(View view){
        //Declarar variables para obtener usuario y password

        String user = etUser.getText().toString();
        String pass = etPass.getText().toString();


        if(!user.isEmpty() && !pass.isEmpty()){
            //se asocian las pantallas
            Intent intentLogin = new Intent(Login.this, PrincipalActivity.class);
            intentLogin.putExtra("Usuario",user); //Se envia un parámetro
            //Se inicia la otra Activity
            startActivity(intentLogin);
        }else{
            Intent intentLogin = new Intent(Login.this, ErrorLogin.class);
            intentLogin.putExtra("Usuario",user); //Se envia un parámetro
            intentLogin.putExtra("password",pass);
            Toast.makeText(Login.this,"Error datos vacíos!", Toast.LENGTH_LONG).show();
        }
    }

}