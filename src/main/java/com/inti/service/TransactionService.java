package com.inti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IPayementDao;
import com.inti.dao.ITransactionDao;
import com.inti.model.Diplome;
import com.inti.model.Payement;
import com.inti.model.Transaction;

@Service
public class TransactionService implements ITransactionService{

	
	@Autowired
	ITransactionDao transDao;
	
	@Override
	public void add(Transaction t) {

		transDao.save(t);
		
	}

	@Override
	public List<Transaction> selectAll() {
		
		List<Transaction> transactions = transDao.findAll();
		
		return transactions;
	}

	@Override
	public Transaction selectById(int id) {
		
		Transaction t = transDao.findById(id).get();
		
		return t;
	}

	@Override
	public void delete(int id) {
		
		transDao.deleteById(id);
		
	}
	
	@Override
	public List<Transaction> selectAllByIdPart(int idPart) {
		
		List<Transaction> trans = transDao.findAllByParticipant_id(idPart);
		return trans;
	}

}
