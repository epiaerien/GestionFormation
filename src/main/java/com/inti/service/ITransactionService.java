package com.inti.service;

import java.util.List;

import com.inti.model.Transaction;

public interface ITransactionService {
	
	public void add(Transaction u);
	public List<Transaction> selectAll();
	public Transaction selectById(int id);
	public void delete(int id);

}
