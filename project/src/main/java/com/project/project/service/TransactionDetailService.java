package com.project.project.service;

import com.project.project.entity.TransactionDetail;
import com.project.project.entity.Transactions;
import com.project.project.repository.TransactionDetailRepo;
import com.project.project.repository.TransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionDetailService {
    @Autowired
    private TransactionDetailRepo transactionDetailRepo;

    @Autowired
    private TransactionsRepo transactionsRepo;

    public List<Map<String, Object>> getTransactionDetailsByTransactionId(int transactionId) {
        Optional<Transactions> optionalTransaction = transactionsRepo.findById(transactionId);
        if (optionalTransaction.isEmpty()) {
            // Handle case when transaction with given id is not found
            return Collections.emptyList();
        }

        Transactions transactions = optionalTransaction.get();
        List<TransactionDetail> transactionDetails = transactionDetailRepo.findByTransaction(transactions);
        List<Map<String, Object>> result = new ArrayList<>();

        for (TransactionDetail detail : transactionDetails) {
            Map<String, Object> detailMap = new HashMap<>();
            detailMap.put("transaction_id", detail.getTransaction().getTransactionId());
            detailMap.put("product_id", detail.getProduct().getProductId());
            detailMap.put("product_name", detail.getProduct().getTitle());
            detailMap.put("quantity", detail.getQuantity());
            detailMap.put("sub_total", detail.getSubtotal());
            result.add(detailMap);
        }

        return result;
    }

}
