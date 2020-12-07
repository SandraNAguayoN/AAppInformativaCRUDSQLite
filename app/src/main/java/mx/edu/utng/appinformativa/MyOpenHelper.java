package mx.edu.utng.appinformativa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;  //Especiales de SQLite
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class MyOpenHelper extends SQLiteOpenHelper {
    //Constantes campos tabla pelicula1
    public static final String tabla = "Noticia";
    public static final String nombre = "nombre";
    public static final String photo = "photo";
    public static final String valoracion = "valoracion";
    public static final String descripcion = "descripcion";


    //Constantes para creación de la base de datos
    public static final String REST_TABLE_CREATE = "CREATE TABLE "+tabla+" ("+nombre+" TEXT PRIMARY KEY , " +
            photo +"TEXT, "+valoracion+" REAL, "+descripcion+" TEXT)";

    private static final String DB_NAME = "noticeme.sqlite";

    private static final int DB_VERSION = 1;

    public MyOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(REST_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Noticia");
        onCreate(db);
    }
}
