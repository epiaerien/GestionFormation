package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IAppelDao;
import com.inti.model.Appel;

@Service
public class AppelService implements IAppelService {

	@Autowired
	IAppelDao apDao; 
	
	@Override
	public void add(Appel a) {
		apDao.save(a);
	}

	@Override
	public List<Appel> selectAll() {
		List<Appel> appels = apDao.findAll(); 
		return appels;
	}

	@Override
	public Appel selectById(int id) {
		Appel appel = apDao.findById(id).get(); 
		return appel;
	}

	@Override
	public void delete(int id) {
		apDao.deleteById(id);
		
	}
	
	
	
}