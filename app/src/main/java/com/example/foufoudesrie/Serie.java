package com.example.foufoudesrie;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;


public class Serie implements Serializable {
    private Integer id;
    private String titre;
    private String resume;
    private String duree;
    private String premiereDiffusion;
    private String image;

    public Serie(Integer i, String t, String r, String d, String pDiff, String img) {
        id = i;
        titre = t;
        resume = r;
        duree = d;
        premiereDiffusion = pDiff;
        image = img;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getPremiereDiffusion() {
        return premiereDiffusion;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}

