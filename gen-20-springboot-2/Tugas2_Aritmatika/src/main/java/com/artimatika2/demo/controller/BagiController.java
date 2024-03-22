package com.artimatika2.demo.controller;


import com.artimatika2.demo.dto.BagiReq;
import com.artimatika2.demo.service.BagiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bagi")
public class BagiController {
    @Autowired
    private BagiService bagiService;

    public BagiController(BagiService bagiService){
        this.bagiService = bagiService;
    }

    @PostMapping("/")
    public BagiReq hasilbagi(@RequestBody BagiReq bagiReq){
        bagiService.setBagiReq(bagiReq);
        return bagiService.getBagiReq();
    }

    @GetMapping("/hasil")
    public BagiReq hasilbagi1(){
        return bagiService.getBagiReq();
    }

}
