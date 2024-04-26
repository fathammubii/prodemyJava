package com.project.project.repository;

import com.project.project.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepo extends JpaRepository<Transactions, Integer> {
}
