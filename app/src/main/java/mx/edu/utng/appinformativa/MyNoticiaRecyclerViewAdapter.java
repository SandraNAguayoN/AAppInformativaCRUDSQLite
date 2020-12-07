package mx.edu.utng.appinformativa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Noticia}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyNoticiaRecyclerViewAdapter extends RecyclerView.Adapter<MyNoticiaRecyclerViewAdapter.ViewHolder> {

    private final List<Noticia> mValues; //Lista de valores de noticia
    private Context contexto;
    //Método constructor de la clase

    public MyNoticiaRecyclerViewAdapter(Context ctx, List<Noticia> items) {
        contexto = ctx;  //Se define contexto
        mValues = items; //La lista de Restaurantes
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_noticia, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //Este método dibuja cada elemento de la lista
        holder.mItem = mValues.get(position);  //Rescatamos los datos de cada elemento
        holder.tvNombre.setText(holder.mItem.getNombre());
        holder.tvDescripcion.setText(holder.mItem.getDescripcion());
        holder.rbValoracion.setRating(holder.rbValoracion.getRating());
        //Para manejo de la imagen

        Glide.with(contexto)
                .load(holder.mItem.getUrlPhoto())
                .centerCrop()
                .placeholder(R.drawable.noticias)
                .error(R.drawable.noticias)
                .into(holder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView; //Hace referencia al constraint layout
        public final TextView tvNombre;
        public final TextView tvDescripcion;
        public final ImageView ivPhoto;
        public final RatingBar rbValoracion;
        public Noticia mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvNombre = (TextView) view.findViewById(R.id.tvNombre);
            tvDescripcion = (TextView) view.findViewById(R.id.tvDescripcion);
            ivPhoto = (ImageView)view.findViewById(R.id.ivPhoto);
            rbValoracion = (RatingBar)view.findViewById(R.id.rbValoracion);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvNombre.getText() + "'";
        }
    }
}