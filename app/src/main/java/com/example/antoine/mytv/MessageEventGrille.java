package com.example.antoine.mytv;

import com.example.antoine.mytv.jsonpojo7.ADiffusion;

import java.util.LinkedList;

public class MessageEventGrille {

    private LinkedList<ADiffusion> listAD= new LinkedList<ADiffusion>();
    private String nomChaine;

    public LinkedList<ADiffusion> getListTitle() {
        return listAD;
    }

    public void addtListTitle(ADiffusion adiff) {
        this.listAD.add(adiff);
    }

    public String getChaine() {
        return nomChaine;
    }

    public void setChaine(String nomChaine) {
        this.nomChaine = nomChaine;
    }
}