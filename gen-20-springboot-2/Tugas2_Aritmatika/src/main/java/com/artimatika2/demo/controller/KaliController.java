package com.artimatika2.demo.controller;

import com.artimatika2.demo.dto.KaliReq;
import com.artimatika2.demo.service.KaliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kali")
public class KaliController {
    @Autowired
    private KaliService kaliService;

//    public KaliController(KaliService kaliService){
//        this.kaliService = kaliService;
//    }

    @PostMapping("/")
    public KaliReq hasilkali(@RequestBody KaliReq kaliReq){
        kaliService.setKaliReq(kaliReq);
        return kaliService.getKaliReq();
    }

}
