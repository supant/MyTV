
package com.example.antoine.mytv.jsonpojo7;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ADiffusion {

    // Un programmme


    @SerializedName("nature")
    @Expose
    private String nature;
    @SerializedName("titre")
    @Expose
    private String titre;
    @SerializedName("urlDiff")
    @Expose
    private String urlDiff;
    @SerializedName("direct")
    @Expose
    private Integer direct;
    @SerializedName("inedit")
    @Expose
    private Integer inedit;
    @SerializedName("teaser")
    @Expose
    private Integer teaser;
    @SerializedName("heureDif")
    @Expose
    private String heureDif;
    @SerializedName("soustitre")
    @Expose
    private String soustitre;
    @SerializedName("t7jLes7")
    @Expose
    private String t7jLes7;
    @SerializedName("idSaison")
    @Expose
    private Integer idSaison;
    @SerializedName("idSerie")
    @Expose
    private Integer idSerie;
    @SerializedName("nbEpi")
    @Expose
    private Integer nbEpi;
    @SerializedName("numEpi")
    @Expose
    private Integer numEpi;
    @SerializedName("saison")
    @Expose
    private Integer saison;
    @SerializedName("serie")
    @Expose
    private String serie;
    @SerializedName("manifestation")
    @Expose
    private Object manifestation;
    @SerializedName("participant")
    @Expose
    private Participant participant;
    @SerializedName("primetime")
    @Expose
    private Integer primetime;
    @SerializedName("photo")
    @Expose
    private String photo;

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public ADiffusion withNature(String nature) {
        this.nature = nature;
        return this;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public ADiffusion withTitre(String titre) {
        this.titre = titre;
        return this;
    }

    public String getUrlDiff() {
        return urlDiff;
    }

    public void setUrlDiff(String urlDiff) {
        this.urlDiff = urlDiff;
    }

    public ADiffusion withUrlDiff(String urlDiff) {
        this.urlDiff = urlDiff;
        return this;
    }

    public Integer getDirect() {
        return direct;
    }

    public void setDirect(Integer direct) {
        this.direct = direct;
    }

    public ADiffusion withDirect(Integer direct) {
        this.direct = direct;
        return this;
    }

    public Integer getInedit() {
        return inedit;
    }

    public void setInedit(Integer inedit) {
        this.inedit = inedit;
    }

    public ADiffusion withInedit(Integer inedit) {
        this.inedit = inedit;
        return this;
    }

    public Integer getTeaser() {
        return teaser;
    }

    public void setTeaser(Integer teaser) {
        this.teaser = teaser;
    }

    public ADiffusion withTeaser(Integer teaser) {
        this.teaser = teaser;
        return this;
    }

    public String getHeureDif() {
        return heureDif;
    }

    public void setHeureDif(String heureDif) {
        this.heureDif = heureDif;
    }

    public ADiffusion withHeureDif(String heureDif) {
        this.heureDif = heureDif;
        return this;
    }

    public String getSoustitre() {
        return soustitre;
    }

    public void setSoustitre(String soustitre) {
        this.soustitre = soustitre;
    }

    public ADiffusion withSoustitre(String soustitre) {
        this.soustitre = soustitre;
        return this;
    }

    public String getT7jLes7() {
        return t7jLes7;
    }

    public void setT7jLes7(String t7jLes7) {
        this.t7jLes7 = t7jLes7;
    }

    public ADiffusion withT7jLes7(String t7jLes7) {
        this.t7jLes7 = t7jLes7;
        return this;
    }

    public Integer getIdSaison() {
        return idSaison;
    }

    public void setIdSaison(Integer idSaison) {
        this.idSaison = idSaison;
    }

    public ADiffusion withIdSaison(Integer idSaison) {
        this.idSaison = idSaison;
        return this;
    }

    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public ADiffusion withIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
        return this;
    }

    public Integer getNbEpi() {
        return nbEpi;
    }

    public void setNbEpi(Integer nbEpi) {
        this.nbEpi = nbEpi;
    }

    public ADiffusion withNbEpi(Integer nbEpi) {
        this.nbEpi = nbEpi;
        return this;
    }

    public Integer getNumEpi() {
        return numEpi;
    }

    public void setNumEpi(Integer numEpi) {
        this.numEpi = numEpi;
    }

    public ADiffusion withNumEpi(Integer numEpi) {
        this.numEpi = numEpi;
        return this;
    }

    public Integer getSaison() {
        return saison;
    }

    public void setSaison(Integer saison) {
        this.saison = saison;
    }

    public ADiffusion withSaison(Integer saison) {
        this.saison = saison;
        return this;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public ADiffusion withSerie(String serie) {
        this.serie = serie;
        return this;
    }

    public Object getManifestation() {
        return manifestation;
    }

    public void setManifestation(Object manifestation) {
        this.manifestation = manifestation;
    }

    public ADiffusion withManifestation(Object manifestation) {
        this.manifestation = manifestation;
        return this;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public ADiffusion withParticipant(Participant participant) {
        this.participant = participant;
        return this;
    }

    public Integer getPrimetime() {
        return primetime;
    }

    public void setPrimetime(Integer primetime) {
        this.primetime = primetime;
    }

    public ADiffusion withPrimetime(Integer primetime) {
        this.primetime = primetime;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ADiffusion withPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public String toString() {
        return "ADiffusion{" +
                "nature='" + nature + '\'' +
                ", titre='" + titre + '\'' +
                ", urlDiff='" + urlDiff + '\'' +
                ", direct=" + direct +
                ", inedit=" + inedit +
                ", teaser=" + teaser +
                ", heureDif='" + heureDif + '\'' +
                ", soustitre='" + soustitre + '\'' +
                ", t7jLes7='" + t7jLes7 + '\'' +
                ", idSaison=" + idSaison +
                ", idSerie=" + idSerie +
                ", nbEpi=" + nbEpi +
                ", numEpi=" + numEpi +
                ", saison=" + saison +
                ", serie='" + serie + '\'' +
                ", manifestation=" + manifestation +
                ", participant=" + participant +
                ", primetime=" + primetime +
                ", photo='" + photo + '\'' +
                '}';
    }
}
