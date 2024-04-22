package com.project.project.repository;

import com.project.project.entity.TransactionDetail;
import com.project.project.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDetailRepo extends JpaRepository<TransactionDetail, Integer> {
    List<TransactionDetail> findByTransaction(Transactions transactions);

}
