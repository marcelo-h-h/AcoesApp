package com.tyt.acoesapp.Network.Api;

import com.tyt.acoesapp.Entity.AcoesListEntity;
import com.tyt.acoesapp.Entity.DetailEntity;
import com.tyt.acoesapp.Network.Service.Service;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by marcelo on 18/12/17.
 */
//Define de onde importar as informações JSON e mostra como usar o retrofit para converter e popular a classe AcoesEntitylist
public class Api {
    private static Api instancia;
    private Service servico;
    private static final String BASE_URL = "https://dl.dropboxusercontent.com/s/50vmlj7dhfaibpj/";

    public static Api getInstance(){
        if (instancia == null){
            instancia = new Api();
        }

        return instancia;
    }

    private Api(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.servico = retrofit.create(Service.class);
    }

    public Call<AcoesListEntity> getAcoes(){
        return servico.getAcoes();
    }

    public Call<DetailEntity> getActionDetail(long movieId){
        return servico.getActionDetail(movieId);
    }
}
