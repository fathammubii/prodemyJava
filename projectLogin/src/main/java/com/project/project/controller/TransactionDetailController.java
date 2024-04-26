package com.project.project.controller;

import com.project.project.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pos/api")
public class TransactionDetailController {

    @Autowired
    private TransactionDetailService transactionDetailService;

    @GetMapping("/listtransaksidetail/{id}")
    public ResponseEntity<List<Map<String, Object>>> getTransactionDetails(@PathVariable("id") int id){
        List<Map<String, Object>> details = transactionDetailService.getTransactionDetailsByTransactionId(id);
        return ResponseEntity.ok(details);
    }
}
