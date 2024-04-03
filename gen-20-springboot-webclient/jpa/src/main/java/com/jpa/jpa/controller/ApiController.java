package com.jpa.jpa.controller;

import com.jpa.jpa.dto.ProvinceResponse;
import com.jpa.jpa.service.ProvinceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/rajaongkir")
public class ApiController {
    private final ProvinceClient provinceClient;

    @Autowired
    public ApiController(ProvinceClient provinceClient){
        this.provinceClient = provinceClient;
    }


    @GetMapping("/fetch")

    public Mono<ResponseEntity<ProvinceResponse>> fetchData(){

        return provinceClient.fetchDataWithHeaders()
                .map(response -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(response)
                );
    }
}
