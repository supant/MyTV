
package com.example.antoine.mytv.jsonpojo7;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Participant {

    @SerializedName("Pr\u00e9sentateur vedette")
    @Expose
    private List<String> prSentateurVedette = null;
    @SerializedName("R\u00e9alisateur")
    @Expose
    private List<String> rAlisateur = null;
    @SerializedName("Acteur")
    @Expose
    private List<String> acteur = null;
    @SerializedName("Musique")
    @Expose
    private List<String> musique = null;
    @SerializedName("Sc\u00e9nario")
    @Expose
    private List<String> scNario = null;
    @SerializedName("Origine Sc\u00e9nario")
    @Expose
    private List<String> origineScNario = null;
    @SerializedName("D\u00e9cors")
    @Expose
    private List<String> dCors = null;
    @SerializedName("Image")
    @Expose
    private List<String> image = null;

    public List<String> getPrSentateurVedette() {
        return prSentateurVedette;
    }

    public void setPrSentateurVedette(List<String> prSentateurVedette) {
        this.prSentateurVedette = prSentateurVedette;
    }

    public Participant withPrSentateurVedette(List<String> prSentateurVedette) {
        this.prSentateurVedette = prSentateurVedette;
        return this;
    }

    public List<String> getRAlisateur() {
        return rAlisateur;
    }

    public void setRAlisateur(List<String> rAlisateur) {
        this.rAlisateur = rAlisateur;
    }

    public Participant withRAlisateur(List<String> rAlisateur) {
        this.rAlisateur = rAlisateur;
        return this;
    }

    public List<String> getActeur() {
        return acteur;
    }

    public void setActeur(List<String> acteur) {
        this.acteur = acteur;
    }

    public Participant withActeur(List<String> acteur) {
        this.acteur = acteur;
        return this;
    }

    public List<String> getMusique() {
        return musique;
    }

    public void setMusique(List<String> musique) {
        this.musique = musique;
    }

    public Participant withMusique(List<String> musique) {
        this.musique = musique;
        return this;
    }

    public List<String> getScNario() {
        return scNario;
    }

    public void setScNario(List<String> scNario) {
        this.scNario = scNario;
    }

    public Participant withScNario(List<String> scNario) {
        this.scNario = scNario;
        return this;
    }

    public List<String> getOrigineScNario() {
        return origineScNario;
    }

    public void setOrigineScNario(List<String> origineScNario) {
        this.origineScNario = origineScNario;
    }

    public Participant withOrigineScNario(List<String> origineScNario) {
        this.origineScNario = origineScNario;
        return this;
    }

    public List<String> getDCors() {
        return dCors;
    }

    public void setDCors(List<String> dCors) {
        this.dCors = dCors;
    }

    public Participant withDCors(List<String> dCors) {
        this.dCors = dCors;
        return this;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public Participant withImage(List<String> image) {
        this.image = image;
        return this;
    }

}
