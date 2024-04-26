package com.project.project.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsReq {
    private Long totalAmount;
    private Long totalPay;
    private LocalDateTime transactionDate;
    private int transactionId;
    private List<TransactionDetailReq> transactionDetailReqList;

}
