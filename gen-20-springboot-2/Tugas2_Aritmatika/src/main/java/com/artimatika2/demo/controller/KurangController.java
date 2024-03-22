package com.artimatika2.demo.controller;


import com.artimatika2.demo.dto.KurangReq;
import com.artimatika2.demo.service.KurangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kurang")
public class KurangController {
    @Autowired
    private KurangService kurangService;

//    public KurangController(KurangService kurangService){
//        this.kurangService = kurangService;
//    }

    @PostMapping("/")
    public KurangReq hasilkurang(@RequestBody KurangReq kurangReq){
        kurangService.setKurangReq(kurangReq);
        return kurangService.getKurangReq();
    }
}
