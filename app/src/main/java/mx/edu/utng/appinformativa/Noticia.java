package mx.edu.utng.appinformativa;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Noticia {
    //Clase POJO Objeto simple de Java
    @PrimaryKey
    @NonNull
    private String nombre;
    private String urlPhoto;
    private float valoracion;
    private String descripcion;

    //Constructor con los parametros de la clase Noticia
    public Noticia(String nombre, String urlPhoto, float valoracion, String descripcion) {
        this.nombre = nombre;
        this.urlPhoto = urlPhoto;
        this.valoracion = valoracion;
        this.descripcion = descripcion;
    }

    //Métodos getter y setter de todos los parámetros de la clase
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
