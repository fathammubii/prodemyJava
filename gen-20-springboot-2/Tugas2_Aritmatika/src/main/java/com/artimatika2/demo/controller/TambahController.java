package com.artimatika2.demo.controller;

import com.artimatika2.demo.dto.TambahReq;
import com.artimatika2.demo.service.TambahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tambah")
public class TambahController {
    @Autowired
    private TambahService tambahService;

    @PostMapping("/")
    public TambahReq hasiltambah(@RequestBody TambahReq tambahReq){
        tambahService.setTambahReq(tambahReq);
        return tambahService.getTambahReq();
    }
}
