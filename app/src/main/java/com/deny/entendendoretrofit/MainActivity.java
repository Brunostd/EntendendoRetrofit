package com.deny.entendendoretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.deny.entendendoretrofit.api.CEPService;
import com.deny.entendendoretrofit.api.DataService;
import com.deny.entendendoretrofit.model.CEP;
import com.deny.entendendoretrofit.model.Foto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button buttonResultado;
    private TextView textViewResultado;
    private Retrofit retrofit;
    private List<Foto> listaFotos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonResultado     = findViewById(R.id.buttonResultado);
        textViewResultado   = findViewById(R.id.textViewResultado);

        retrofit = new Retrofit.Builder()
                //.baseUrl("https://viacep.com.br/ws/")
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        buttonResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //recuperarCEPRetrofit();
                recuperarListaRetrofit();

            }
        });
    }

    public void recuperarListaRetrofit(){

        DataService service = retrofit.create(DataService.class);
        Call<List<Foto>> call = service.recuperarFotos();

        call.enqueue(new Callback<List<Foto>>() {
            @Override
            public void onResponse(Call<List<Foto>> call, Response<List<Foto>> response) {
                if (response.isSuccessful()){
                    listaFotos = response.body();

                    for (int i = 0; i < 100; i++ ){
                        Foto foto = listaFotos.get( i );
                        Log.d("resultado", " resultado: "+ foto.getId() +" / "+ foto.getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Foto>> call, Throwable t) {

            }
        });
    }

    /*public void recuperarCEPRetrofit(){
        CEPService cepService = retrofit.create(CEPService.class);
        Call<CEP> call = cepService.recuperarCep("62370000");

        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if (response.isSuccessful()){
                    CEP cep = response.body();
                    textViewResultado.setText(cep.getLogradouro()+" / "+cep.getBairro());
                }
            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {

            }
        });
    }*/
}