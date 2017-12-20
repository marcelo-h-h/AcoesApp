package com.tyt.acoesapp.telaInicial;

import com.tyt.acoesapp.Entity.AcaoSocial;

import java.util.List;

/**
 * Created by marcelo on 18/12/17.
 */

public interface mainView {
    void updateList(List<AcaoSocial> actionsList);
    void showMessage(String msg);
    void showLoading();
    void hideLoading();
}
