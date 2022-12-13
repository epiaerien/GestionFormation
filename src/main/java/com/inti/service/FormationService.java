package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IFormationDao;
import com.inti.model.Formation;



@Service
public class FormationService implements IFormationService {

	
	@Autowired
	IFormationDao formationDao;
	
	
	@Override
	public void add(Formation form) {
		formationDao.save(form);
	}
	
	
	@Override
	public List<Formation> selectAll(){
		List<Formation> forms = formationDao.findAll();
		return forms;		
	}
	
	
	@Override
	public Formation selectById(int id) {
		Formation form = formationDao.findById(id).get();
		return form;
	}
	
	
	@Override
	public void delete(int id) {
		formationDao.deleteById(id);
	}
}
