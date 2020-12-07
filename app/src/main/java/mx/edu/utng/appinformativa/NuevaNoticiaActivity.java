package mx.edu.utng.appinformativa;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static mx.edu.utng.appinformativa.MyOpenHelper.tabla;

public class NuevaNoticiaActivity extends AppCompatActivity {
    //private Button btnAgregar, btnRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_noticia);

        final Button btnCrear=(Button)findViewById(R.id.btnCrear);
        final Button btnRegresar=(Button)findViewById(R.id.btnRegresar);
        final EditText etNombre=findViewById(R.id.etNombre);
        final EditText etPhoto=findViewById(R.id.etPhoto);
        final EditText etDescripcion=findViewById(R.id.etDescripcion);
        final RatingBar rbValoracion=findViewById(R.id.ratingBar);

        //Manejo del evento de Onclick a btnAgregar
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyOpenHelper dbHelper = new MyOpenHelper(NuevaNoticiaActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase(); //Conecta a la BD para acceder a sus datos

                if (db != null) { //Elaúa si la BD no esta vacía
                    // Hacer las operaciones que queramos sobre la base de datos
                    ContentValues cv = new ContentValues();
                    cv.put("nombre", etNombre.getText().toString()); //Inserta el valor del EditText a la columna "nombre"
                    cv.put("photo", etPhoto.getText().toString());
                    cv.put("valoracion", rbValoracion.getRating());
                    cv.put("descripcion", etDescripcion.getText().toString());
                    try {
                        db.insert(tabla, null, cv);
                        etNombre.setText("");
                        etPhoto.setText("");
                        rbValoracion.setRating(0.0f);
                        etDescripcion.setText("");
                        Toast.makeText(NuevaNoticiaActivity.this, "Se ha agregado una nueva pelicula",
                                Toast.LENGTH_LONG).show();
                    }catch (Exception ex){
                        Toast.makeText(NuevaNoticiaActivity.this, "Error:"+ex.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }finally {
                        db.close();
                    }

                }
            }
        });

        //Metodo que se dispara al dar clic en btnRegresar y realiza intent hacia la vista de ListaNoticiaActivity
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLista = new Intent(NuevaNoticiaActivity.this, ListaNoticiaActivity.class);
                startActivity(intentLista);  //Inicia ListaNoticiaActivity
                finish(); //Finaliza ListaNoticiaActivity
            }
        });
    }
}