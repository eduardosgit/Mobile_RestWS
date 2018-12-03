package professorangoti.com.restcomlistview;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import professorangoti.com.restcomlistview.modelo.Post;

public class PostAdapter extends BaseAdapter {

    Context contexto;
    List<Post> lista;

    public PostAdapter(Context contexto, List<Post> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View linha = LayoutInflater.from(contexto).inflate(R.layout.lista2, null);
        Post post = lista.get(position);

        TextView nome = (TextView) linha.findViewById(R.id.textView);
        TextView titulo = (TextView) linha.findViewById(R.id.textView2);

        nome.setText(post.getUserId() + "");
        titulo.setText(post.getTitle());
        return linha;
    }
}

