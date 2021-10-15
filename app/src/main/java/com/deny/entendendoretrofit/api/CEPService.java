package com.deny.entendendoretrofit.api;

import com.deny.entendendoretrofit.model.CEP;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {
    @GET("{cep}/json/")
    Call<CEP> recuperarCep(@Path("cep") String cep);
}
