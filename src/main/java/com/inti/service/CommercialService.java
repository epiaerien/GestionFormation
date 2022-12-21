package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.ICommercialDao;
import com.inti.model.Commercial;


@Service
public class CommercialService implements ICommercialService{
	
	@Autowired
	ICommercialDao comDao;

	@Override
	public void add(Commercial c) {
		comDao.save(c);
		
	}

	@Override
	public List<Commercial> selectAll() {
		List<Commercial> commercials = comDao.findAll();
		return commercials;
	}

	@Override
	public Commercial selectById(int id) {
		Commercial c  = comDao.findById(id).get();
		
		return c;
	}

	@Override
	public void delete(int id) {
		comDao.deleteById(id);
		
	}
	
	public Commercial commercialparappel(int id)
	{
		Commercial c = comDao.findByAppelsProspect_id(id); 
		return c ;	
	}
	
	public Commercial commercialparrdv(int id)
	{
		Commercial c = comDao.findByRdvProspect_id(id); 
		return c; 
	}
	
	

}
