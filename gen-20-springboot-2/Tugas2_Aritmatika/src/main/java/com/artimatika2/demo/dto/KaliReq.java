package com.artimatika2.demo.dto;

public class KaliReq {
    private int x;
    private int y;
    private int hasilkali;

    public KaliReq() {
    }
    public KaliReq(int x, int y) {
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

    public void setHasilkali(){
        this.hasilkali = x*y;
    }
    public double getHasilkali(){
        return hasilkali;
    }
}
