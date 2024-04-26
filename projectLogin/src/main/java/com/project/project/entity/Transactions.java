package com.project.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transactionId;

    @Column(name = "total_amount")
    private int totalAmount;

    @Column(name = "total_pay")
    private int totalPay;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @OneToMany(mappedBy = "transaction")
    private List<TransactionDetail> transactionDetails;

}
