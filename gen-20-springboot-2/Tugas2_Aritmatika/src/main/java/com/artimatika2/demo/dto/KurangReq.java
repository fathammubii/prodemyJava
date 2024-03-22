package com.artimatika2.demo.dto;

public class KurangReq {
    private int x;
    private int y;
    private int hasilkurang;

    public KurangReq() {
    }
    public KurangReq(int x, int y) {
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

    public void setHasilkurang(){
        this.hasilkurang = x-y;
    }
    public double getHasilkurang(){
        return hasilkurang;
    }
}
