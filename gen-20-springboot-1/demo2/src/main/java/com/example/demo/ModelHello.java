package com.example.demo;

public class ModelHello {
    private String kata;

    public ModelHello(String kata){
        this.kata = kata;
    }

    public String getHello(){
        return kata;
    }

    public void setHello(String kata){
        this.kata = kata;
    }

}
