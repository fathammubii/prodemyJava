package com.artimatika2.demo.service;

import com.artimatika2.demo.dto.TambahReq;
import org.springframework.stereotype.Service;

@Service
public class TambahService {
    private TambahReq tambahReq;

    public TambahService(){
        this.tambahReq = new TambahReq();
    }

    public TambahReq getTambahReq(){
        return tambahReq;
    }

    public void setTambahReq(TambahReq tambahReq){
        this.tambahReq.setX(tambahReq.getX());
        this.tambahReq.setY(tambahReq.getY());
        this.tambahReq.setHasiltambah();
    }
}
