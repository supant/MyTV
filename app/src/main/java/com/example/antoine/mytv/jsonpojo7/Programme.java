
package com.example.antoine.mytv.jsonpojo7;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Programme {

    @SerializedName("grille")
    @Expose
    private Grille grille;

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public Programme withGrille(Grille grille) {
        this.grille = grille;
        return this;
    }

}
