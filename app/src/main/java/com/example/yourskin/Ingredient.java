package com.example.yourskin;

public class Ingredient {
    public int id;
    public String denumire,tip, descriere;

    public Ingredient(int id, String denumire,String tip, String descriere){
        this.id=id;
        this.denumire=denumire;
        this.tip=tip;
        this.descriere=descriere;
    }

    public Ingredient(){

    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire(){
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getTip(){
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getDescriere(){
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
