package com.inti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IDiplomeDao;
import com.inti.dao.IFormateurDao;
import com.inti.dao.IFormationDao;
import com.inti.model.Formateur;
import com.inti.model.Formation;



@Service
public class FormationService implements IFormationService {

	
	@Autowired
	IFormationDao formationDao;
	

	@Autowired
	IDiplomeDao diplomeDao;

	@Override
	public List<Formation> getbyidformateur(int id)
	{
		List<Formation> formations = formationDao.findByFormateur_id(id); 
		return formations; 
		
	}

	
	@Override
	public Set<Formation> getByidParticipants(int id) {
		Set<Formation> forms = formationDao.findAllByParticipants_id(id);
		//List<Formation> formnoDoublon = forms.stream().collect(Collector.toCollection(() -> new TreeSet<>(comparingInt(Formation::getNom))),
                                                           //ArrayList<Formation>::new));
		//List<Formation > formnoDoublon= new ArrayList<>();
		

		return forms;
	}
	
	@Override
	public void add(Formation form) {
		formationDao.save(form);
	}
	
	//ajouter formation pour un participant
	
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
