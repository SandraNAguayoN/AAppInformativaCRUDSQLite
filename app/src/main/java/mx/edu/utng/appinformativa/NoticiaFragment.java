package mx.edu.utng.appinformativa;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static mx.edu.utng.appinformativa.MyOpenHelper.tabla;

//import mx.edu.utng.apprecyclergds0243.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 */
public class NoticiaFragment extends Fragment {

    //Declaraciones:
    RecyclerView recyclerView;
    List<Noticia> noticiaList;  //Lista de Peliculas en estreno
    MyNoticiaRecyclerViewAdapter adapterNoticias;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NoticiaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NoticiaFragment newInstance(int columnCount) {
        NoticiaFragment fragment = new NoticiaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noticia_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            try {
                MyOpenHelper dbHelper = new MyOpenHelper(getContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String consultaSQL = "SELECT * FROM "+tabla;

                Cursor resultado = db.rawQuery(consultaSQL, null);
                noticiaList = new ArrayList<>();  //Estructura de datos

                while (resultado.moveToNext()) {   //Recorrer el cursor
                    String nombre = resultado.getString(0);  //Primera columna
                    String photo = resultado.getString(1);
                    float valoracion = resultado.getFloat(2);
                    String descripcion = resultado.getString(3);
                    Noticia r = new Noticia(nombre, photo, valoracion, descripcion);
                    noticiaList.add(r);
                }
            }catch (Exception e){
                Toast.makeText(getContext(),"Error: "+e.getMessage(),Toast.LENGTH_LONG).show();

            }


            //Datos
            /*
            restauranteList.add(new Restaurante("Pizzeria Marchelos","https://cdn.kiwilimon.com/recetaimagen/13003/5707.jpg", 4.0f,"Tlaxcala #49"));
            restauranteList.add(new Restaurante("Pollo Feliz","https://www.pollofelizpuebla.com/images/logo.png",3.5f,"José Alfredo #3"));
            restauranteList.add(new Restaurante("Pollo Sabroso","https://thumbs.dreamstime.com/z/pollo-sabroso-hecho-en-casa-del-rotisserie-la-placa-blanca-vista-lateral-primer-140690225.jpg",5.0f,"Michoacan #65"));
            */
            //Se asocia el adaptador al RecyclerView
            adapterNoticias = new MyNoticiaRecyclerViewAdapter(getActivity(), noticiaList);
            recyclerView.setAdapter(adapterNoticias);


            //recyclerView.setAdapter(new MyRestauranteRecyclerViewAdapter(DummyContent.ITEMS));
        }
        return view;
    }


}