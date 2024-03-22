package com.artimatika2.demo.service;

import com.artimatika2.demo.dto.KurangReq;
import org.springframework.stereotype.Service;

@Service
public class KurangService {
    private KurangReq kurangReq;

    public KurangService(){
        this.kurangReq = new KurangReq();
    }

    public KurangReq getKurangReq(){
        return kurangReq;
    }

    public void setKurangReq(KurangReq kurangReq){
        this.kurangReq.setX(kurangReq.getX());
        this.kurangReq.setY(kurangReq.getY());
        this.kurangReq.setHasilkurang();
    }
}
