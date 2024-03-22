package com.artimatika2.demo.service;

import com.artimatika2.demo.dto.BagiReq;
import org.springframework.stereotype.Service;

@Service
public class BagiService {
    private BagiReq bagiReq;

    public BagiService() {
        this.bagiReq = new BagiReq();
    }

    public BagiReq getBagiReq(){
//        this.bagiReq.getHasilbagi();
        return bagiReq;
    }

    public void setBagiReq(BagiReq bagiReq){
        this.bagiReq.setX(bagiReq.getX());
        this.bagiReq.setY(bagiReq.getY());
        this.bagiReq.setHasilbagi();
//        this.bagiReq.getHasilbagi();
    }
}
