package com.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Transaction;

public interface ITransactionDao extends JpaRepository<Transaction, Integer>{

}
