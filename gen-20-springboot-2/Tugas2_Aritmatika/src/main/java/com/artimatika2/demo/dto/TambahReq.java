package com.artimatika2.demo.dto;

public class TambahReq {
    private int x;
    private int y;
    private int hasiltambah;

    public TambahReq() {
    }
    public TambahReq(int x, int y) {
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

    public void setHasiltambah(){
        this.hasiltambah = x+y;
    }
    public double getHasiltambah(){
        return hasiltambah;
    }
}
