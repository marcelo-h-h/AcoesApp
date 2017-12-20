package com.tyt.acoesapp.telaInicial;

import com.tyt.acoesapp.Entity.AcaoSocial;
import com.tyt.acoesapp.Entity.AcoesListEntity;
import com.tyt.acoesapp.Network.Api.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by marcelo on 18/12/17.
 */

public class MainPresenter {
    private mainView actionsView;
    private AcoesListEntity actionsListEntity;
    private List<AcaoSocial> actionsList;

    MainPresenter(mainView actionsView){
        this.actionsView = actionsView;
    }
    //Verifica e recebe os dados da api
    void updateList(){
        final Api acoesApi = Api.getInstance();
        actionsView.showLoading();
        acoesApi.getAcoes().enqueue(new Callback<AcoesListEntity>() {
            @Override
            public void onResponse(Call<AcoesListEntity> call, Response<AcoesListEntity> response) {
                actionsView.hideLoading();
                actionsListEntity = response.body();
                if(actionsListEntity != null){
                    actionsList = actionsListEntity.getAcoesSociais();
                    actionsView.updateList(actionsList);
                    //actionsView.AtivarRecycler();
                } else {
                    actionsView.showMessage("Houve um erro");
                }
            }

            @Override
            public void onFailure(Call<AcoesListEntity> call, Throwable t) {
                actionsView.hideLoading();
                actionsView.showMessage("Falha no acesso ao servidor");
            }
        });
    }

    long getActionId(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getId();
    }

    String getActionName(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getName();
    }
    String getActionDescription(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getDescription();
    }
    String getActionSite(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getSite();
    }
    String getActionImage(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getImage();
    }


}
