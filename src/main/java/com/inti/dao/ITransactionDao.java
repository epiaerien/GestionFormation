package com.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Transaction;

public interface ITransactionDao extends JpaRepository<Transaction, Integer>{

	public List<Transaction> findAllByParticipant_id (int idPart);
}
