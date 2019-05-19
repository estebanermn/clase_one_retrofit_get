package pe.edu.cibertec;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button btSearch;
    TextInputEditText etMovie;
    TextView tvTitle, tvYear, tvPlop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etMovie = findViewById(R.id.etMovie);
        btSearch = findViewById(R.id.btSearch);
        tvTitle = findViewById(R.id.tvTitle);
        tvYear = findViewById(R.id.tvYear);
        tvPlop = findViewById(R.id.tvPlot);

        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String apikey = "6fc43ba7";
                String name = etMovie.getText().toString();

                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.omdbapi.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                MovieInterface movieInteface = retrofit.create(MovieInterface.class);
                movieInteface.searchMovie(apikey, name);
                Call<Movie> methodSearch = movieInteface.searchMovie(apikey, name);

                methodSearch.enqueue(new Callback<Movie>() {
                    @Override
                    public void onResponse(Call<Movie> call, Response<Movie> response) {
                        if(response.isSuccessful()){
                            Movie movie = response.body();
                            tvTitle.setText(movie.getTitle());
                            tvYear.setText(movie.getYear());
                            tvPlop.setText(movie.getPlop());
                        }
                    }

                    @Override
                    public void onFailure(Call<Movie> call, Throwable t) {

                    }
                });
            }
        });


    }
}
