package com.project.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction_details")
public class TransactionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_detail_id")
    private int transactionDetailId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "subtotal")
    private int subtotal;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transactions transaction;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
