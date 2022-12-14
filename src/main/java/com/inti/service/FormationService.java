package com.inti.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IDiplomeDao;
import com.inti.dao.IFormateurDao;
import com.inti.dao.IFormationDao;
import com.inti.dao.IParticipantDao;
import com.inti.model.Diplome;
import com.inti.model.Formateur;
import com.inti.model.Formation;



@Service
public class FormationService implements IFormationService {

	
	@Autowired
	IFormationDao formationDao;
	

	@Autowired
	IDiplomeDao diplomeDao;
	
	@Autowired
	IParticipantDao partiDao;

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
	public void addFormLinkedtoPart(Formation form, int idpart) {
		List<Diplome> ListDiplForm = diplomeDao.findAllByFormation_id(form.getId());
		form.setDiplomes(ListDiplForm);
		Diplome dipl = new Diplome();
		dipl.setNom("Diplome de" + form.getNom());
		dipl.setFormation(form);
		dipl.setParticipant(partiDao.findById(idpart).get());
		diplomeDao.save(dipl);
		List<Diplome> listDipl = new ArrayList<>();
		if(form.getDiplomes()!=null) {
			listDipl = form.getDiplomes();
		}		
		System.out.println("avant ajout" + listDipl.size());
		listDipl.add(dipl);
		System.out.println("apres ajout" + listDipl.size());
		form.setDiplomes(listDipl);
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
