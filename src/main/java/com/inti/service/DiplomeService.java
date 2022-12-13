package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IDiplomeDao;
import com.inti.model.Diplome;

@Service
public class DiplomeService implements IDiplomeService{

	@Autowired
	IDiplomeDao dipDao;
	
	@Override
	public void add(Diplome d) {
		dipDao.save(d);	
	}

	@Override
	public List<Diplome> selectAll() {
		
		List<Diplome> diplomes = dipDao.findAll();
		return diplomes;
	}

	@Override
	public Diplome selectById(int id) {
		Diplome d = dipDao.findById(id).get();
		return d;
	}

	@Override
	public void delete(int id) {
		
		dipDao.deleteById(id);
		
	}
	
	

}
