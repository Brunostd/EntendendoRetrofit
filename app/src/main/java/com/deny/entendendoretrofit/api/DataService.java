package com.deny.entendendoretrofit.api;

import com.deny.entendendoretrofit.model.Foto;
import com.deny.entendendoretrofit.model.Postagens;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET("/photos")
    Call<List<Foto>> recuperarFotos();

    @GET("/posts")
    Call<List<Postagens>> recuperarPostagens();
}
