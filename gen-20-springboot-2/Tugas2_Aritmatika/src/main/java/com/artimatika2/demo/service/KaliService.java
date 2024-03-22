package com.artimatika2.demo.service;

import com.artimatika2.demo.dto.KaliReq;
import org.springframework.stereotype.Service;

@Service
public class KaliService {
    private KaliReq kaliReq;

    public KaliService() {
        this.kaliReq = new KaliReq();
    }

    public KaliReq getKaliReq(){
        return kaliReq;
    }

    public void setKaliReq(KaliReq kaliReq){
        this.kaliReq.setX(kaliReq.getX());
        this.kaliReq.setY(kaliReq.getY());
        this.kaliReq.setHasilkali();
    }
}
