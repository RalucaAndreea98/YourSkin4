package com.example.yourskin;

public class Produs {

    public String denumire,tip, brand, ingrediente, rank;
  public int id;

    public Produs(String brand , String denumire,String tip, String ingrediente, String rank){
        this.brand=brand;
        this.denumire=denumire;
        this.tip=tip;
        this.ingrediente=ingrediente;
        this.rank=rank;
    }

    public Produs(){

    }
    //public int getId(){
       // return id;
   // }

    //public void setId(int id) {
       // this.id = id;
   // }

    public String getBrand(){ return brand; }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getIngrediente(){
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getRank(){
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}