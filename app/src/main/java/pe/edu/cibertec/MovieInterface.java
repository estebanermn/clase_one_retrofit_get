package pe.edu.cibertec;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieInterface {

    @GET("?")
    Call<Movie> searchMovie(@Query("apikey") String apiKey, @Query("t") String name);


}
