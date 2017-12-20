package com.tyt.acoesapp.Acoes;

import com.tyt.acoesapp.Entity.DetailEntity;
import com.tyt.acoesapp.Network.Api.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by marcelo on 18/12/17.
 */

public class AcaoPresenter {
    private AcaoView view;

    public AcaoPresenter(AcaoView view) {
        this.view = view;
    }

    public void getActionDetail(long idActionSelected) {
        final Api acoesApi =  Api.getInstance();
        view.showLoading();
        acoesApi.getActionDetail(idActionSelected).enqueue(new Callback<DetailEntity>() {
            @Override
            public void onResponse(Call<DetailEntity> call, Response<DetailEntity> response) {
                view.hideLoading();
                DetailEntity detailEntity = response.body();
                if(detailEntity != null)
                    view.showDetails(detailEntity);
                else
                    view.showMessage("Erro ao importar informações");
            }

            @Override
            public void onFailure(Call<DetailEntity> call, Throwable t) {
                view.hideLoading();
                view.showMessage("Falha no acesso ao servidor");
            }
        });
    }
}
