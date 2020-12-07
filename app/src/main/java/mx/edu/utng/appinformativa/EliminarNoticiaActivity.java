package mx.edu.utng.appinformativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class EliminarNoticiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_noticia);

        final Button btnEliminar=(Button)findViewById(R.id.btnEliminar);
        final Button btnBuscar=(Button)findViewById(R.id.btnBuscar);
        final Button btnRegresar=(Button)findViewById(R.id.btnRegresar);
        final EditText etNombre=findViewById(R.id.etNombre);
        final EditText etPhoto=findViewById(R.id.etPhoto);
        final EditText etDescripcion=findViewById(R.id.etDescripcion);
        final RatingBar rbValoracion=findViewById(R.id.ratingBar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyOpenHelper dbHelper = new MyOpenHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String[] parametros = {etNombre.getText().toString()};
                String[] campos = {MyOpenHelper.nombre, MyOpenHelper.photo, MyOpenHelper.valoracion, MyOpenHelper.descripcion};

                try{
                    Cursor cursor = db.query(MyOpenHelper.tabla, campos, MyOpenHelper.nombre+"=?",parametros,null,null,null);
                    cursor.moveToFirst();
                    etNombre.setText(cursor.getString(0));
                    etPhoto.setText(cursor.getString(1));
                    rbValoracion.setRating(cursor.getFloat(2));
                    etDescripcion.setText(cursor.getString(3));
                    cursor.close();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "La película no existe", Toast.LENGTH_LONG).show();
                    limpiar();
                }
            }
            private void limpiar() {
                etNombre.setText("");
                etPhoto.setText("");
                rbValoracion.setRating(0.0f);
                etDescripcion.setText("");
            }

        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyOpenHelper dbHelper = new MyOpenHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String[] parametros = {etNombre.getText().toString()};

                try {
                    db.delete(MyOpenHelper.tabla, MyOpenHelper.nombre + "=?", parametros);
                    Toast.makeText(getApplicationContext(), "Se ha eliminado el registro de la película", Toast.LENGTH_LONG).show();
                    limpiar();
                    db.close();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "No se pudo eliminar la película", Toast.LENGTH_LONG).show();
                }
            }
            private void limpiar() {
                etNombre.setText("");
                etPhoto.setText("");
                rbValoracion.setRating(0.0f);
                etDescripcion.setText("");
            }

        });


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLista = new Intent(EliminarNoticiaActivity.this, ListaNoticiaActivity.class);
                startActivity(intentLista);  //Inicia ListaNoticiaActivity
                finish(); //Finaliza ListaNoticiaActivity
            }
        });
    }
}