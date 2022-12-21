package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IPayementDao;
import com.inti.model.Payement;

@Service
public class PayementService implements IPayementService{

	@Autowired
	IPayementDao payDao;
	
	
	@Override
	public void add(Payement p) {
		
		payDao.save(p);
		
	}

	@Override
	public List<Payement> selectAll() {
		
		List<Payement> payements = payDao.findAll();
		
		return payements;
	}

	@Override
	public Payement selectById(int id) {
		
		Payement p = payDao.findById(id).get();
		
		return p;
	}

	@Override
	public void delete(int id) {
		
		payDao.deleteById(id);
		
	}
	
	@Override
	public Payement selectByIdTrans(int idTrans) {
		
		Payement p = payDao.findByTransactions_Id(idTrans);
		
		return p;
	}
	


	
	
}
