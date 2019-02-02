
package com.example.antoine.mytv.jsonpojo7;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Grille {

    @SerializedName("idChaine")
    @Expose
    private Integer idChaine;
    @SerializedName("nomChaine")
    @Expose
    private String nomChaine;
    @SerializedName("dateGrille")
    @Expose
    private String dateGrille;
    @SerializedName("aDiffusion")
    @Expose
    private List<ADiffusion> aDiffusion = null;

    public Integer getIdChaine() {
        return idChaine;
    }
    

    public void setIdChaine(Integer idChaine) {
        this.idChaine = idChaine;
    }

    public Grille withIdChaine(Integer idChaine) {
        this.idChaine = idChaine;
        return this;
    }

    public String getNomChaine() {
        return nomChaine;
    }

    public void setNomChaine(String nomChaine) {
        this.nomChaine = nomChaine;
    }

    public Grille withNomChaine(String nomChaine) {
        this.nomChaine = nomChaine;
        return this;
    }

    public String getDateGrille() {
        return dateGrille;
    }

    public void setDateGrille(String dateGrille) {
        this.dateGrille = dateGrille;
    }

    public Grille withDateGrille(String dateGrille) {
        this.dateGrille = dateGrille;
        return this;
    }

    public List<ADiffusion> getADiffusion() {
        return aDiffusion;
    }

    public void setADiffusion(List<ADiffusion> aDiffusion) {
        this.aDiffusion = aDiffusion;
    }

    public Grille withADiffusion(List<ADiffusion> aDiffusion) {
        this.aDiffusion = aDiffusion;
        return this;
    }

}
