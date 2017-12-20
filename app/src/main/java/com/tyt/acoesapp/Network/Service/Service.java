package com.tyt.acoesapp.Network.Service;

import com.tyt.acoesapp.Entity.AcoesListEntity;
import com.tyt.acoesapp.Entity.DetailEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by marcelo on 18/12/17.
 */

public interface  Service {

    @GET("sociais.json")
    Call<AcoesListEntity> getAcoes();

    @GET("id")
    Call<DetailEntity> getActionDetail(@Query("id") long actionId);
}
