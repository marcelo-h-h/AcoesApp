package com.tyt.acoesapp.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by marcelo on 18/12/17.
 */
//Mostra como o que é retirado do Json deve ser interpretado e manipulado
public class AcaoSocial {
    @SerializedName("id") @Expose private int id;
    @SerializedName("name") @Expose private String name;
    @SerializedName("image") @Expose private String image;
    @SerializedName("description") @Expose private  String description;
    @SerializedName("site") @Expose private String site;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getImage() {
        return image;
    }
    public String getDescription() {
        return description;
    }
    public String getSite() {
        return site;
    }

}
