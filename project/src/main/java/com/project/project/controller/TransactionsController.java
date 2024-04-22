package com.project.project.controller;

import com.project.project.dto.CustomResponse;
import com.project.project.dto.TransactionsReq;
import com.project.project.entity.Transactions;
import com.project.project.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/pos/api")
public class TransactionsController {
    @Autowired
    private TransactionsService transactionsService;

    @PostMapping("/addtransaction")
    public ResponseEntity<CustomResponse> addTransactions(@RequestBody TransactionsReq transactionsReq){
        CustomResponse response = transactionsService.createTransactions(transactionsReq);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listtransaksi")
    public ResponseEntity<List<Map<String, Object>>> getAllTransactions(){
        List<Map<String, Object>> transactions = transactionsService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }
}
