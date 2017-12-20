package com.tyt.acoesapp.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by marcelo on 18/12/17.
 */

public class AcoesListEntity {
    @SerializedName("acoes_sociais") @Expose
    private List<AcaoSocial> acoesSociais = null;

    public List<AcaoSocial> getAcoesSociais() {
        return acoesSociais;
    }
}
