package com.artimatika2.demo.dto;

public class BagiReq {
    private int x;
    private int y;
    private double hasilbagi;

    public BagiReq() {
    }
    public BagiReq(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHasilbagi(){
        this.hasilbagi = (double) x/y;
    }
    public double getHasilbagi(){
        return hasilbagi;
    }
}
