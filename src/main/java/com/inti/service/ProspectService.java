package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IProspectDao;
import com.inti.model.Prospect;

@Service
public class ProspectService implements IProspectService {

	
	@Autowired
	IProspectDao prDao; 
	
	
	@Override
	public void add(Prospect p) {
	prDao.save(p); 
		
	}

	@Override
	public List<Prospect> selectAll() {
		List<Prospect> prospects = prDao.findAll(); 
		return prospects;
	}

	@Override
	public Prospect selectById(int id) {
		Prospect prospect = prDao.findById(id).get(); 
		return prospect;
	}

	@Override
	public void delete(int id) {
		prDao.deleteById(id);
		
	}

}
