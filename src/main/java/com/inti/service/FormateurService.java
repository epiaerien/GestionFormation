package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IFormateurDao;
import com.inti.model.Formateur;

@Service
public class FormateurService implements IFormateurService {

	@Autowired
	IFormateurDao foDao; 
	
	
	@Override
	public void add(Formateur f) {
		foDao.save(f); 
		
	}

	@Override
	public List<Formateur> selectAll() {
		List<Formateur> formateurs = foDao.findAll(); 
		return formateurs;
	}

	@Override
	public Formateur selectById(int id) {
		Formateur formateur = foDao.findById(id).get(); 
		return formateur;
	}

	@Override
	public void delete(int id) {
		foDao.deleteById(id);
		
	}

}
