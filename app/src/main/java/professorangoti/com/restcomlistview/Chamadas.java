package professorangoti.com.restcomlistview;

import java.util.List;

import professorangoti.com.restcomlistview.modelo.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Chamadas {

    @GET("posts")
    Call<List<Post>> obterPost();

}
