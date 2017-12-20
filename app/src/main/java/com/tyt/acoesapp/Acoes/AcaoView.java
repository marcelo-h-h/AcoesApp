package com.tyt.acoesapp.Acoes;

import com.tyt.acoesapp.Entity.DetailEntity;

/**
 * Created by marcelo on 18/12/17.
 */

public interface AcaoView {
    void showDetails(DetailEntity detailEntity);
    void showMessage(String msg);
    void showLoading();
    void hideLoading();
}
