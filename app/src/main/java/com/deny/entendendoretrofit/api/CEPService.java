package com.deny.entendendoretrofit.api;

import com.deny.entendendoretrofit.model.CEP;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CEPService {
    @GET("01001000/json/")
    Call<CEP> recuperarCep();
}
