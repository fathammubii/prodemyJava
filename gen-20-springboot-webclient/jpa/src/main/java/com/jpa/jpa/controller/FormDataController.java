package com.jpa.jpa.controller;

import com.jpa.jpa.dto.FormData;
import com.jpa.jpa.service.FormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/form")
public class FormDataController {
    private FormDataService formDataService;

    @Autowired
    public void FormDataService(FormDataService formDataService){
        this.formDataService = formDataService;
    }

//    @PostMapping("/data")
//    public Mono<ResponseEntity<String>> postDataToApi(@RequestBody FormData formData){
//        return formDataService.postData(formData.getOrigin(), formData.getDestination(), formData.getWeight(), formData.getCourier())
//                .map(response -> ResponseEntity.ok().body(response))
//                .onErrorResume(error -> Mono.just(ResponseEntity.status(500).body(error.getMessage())));
//    }

    @PostMapping("/post")
    public Mono<ResponseEntity<String>> postDataToApi(){
        FormData formData = new FormData();
        formData.setOrigin("12");
        formData.setDestination("20");
        formData.setWeight(1200);
        formData.setCourier("jne");

        return formDataService.postData(formData.getOrigin(), formData.getDestination(), formData.getWeight(), formData.getCourier())
                .map(response -> ResponseEntity.ok().body(response))
                .onErrorResume(error -> Mono.just(ResponseEntity.status(500).body(error.getMessage())));
    }
}
