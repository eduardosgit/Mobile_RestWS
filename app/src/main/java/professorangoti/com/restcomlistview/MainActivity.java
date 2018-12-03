package professorangoti.com.restcomlistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import professorangoti.com.restcomlistview.modelo.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {
    private final String BASE_URL = "http://provaddm2018.000webhostapp.com/lista_de_alunos/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chamada();
    }

    private Chamadas getRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        return (new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()).create(Chamadas.class);
    }

    private void chamada() {
        Call<List<Post>> call = getRetrofit().obterPost();
        call.enqueue(new Callback<List<Post>>() {//chamada assíncrona
            public void onResponse(Call<List<Post>> call,
                                   Response<List<Post>> response) {
                int statusCode = response.code();
                List<Post> posts = response.body();
                setListAdapter(new PostAdapter(MainActivity.this, posts));
                getListView().setOnItemClickListener(MainActivity.this);
            }

            public void onFailure(Call<List<Post>> call, Throwable t) {
                // Log error here since request failed
                Log.i("teste", t.toString());
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,((TextView)view.findViewById(R.id.textView)).getText().toString(),Toast.LENGTH_SHORT).show();
    }
}
