package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IDiplomeDao;
import com.inti.dao.IParticipantDao;
import com.inti.dao.ITransactionDao;
import com.inti.model.Diplome;
import com.inti.model.Formation;
import com.inti.model.Participant;
import com.inti.model.Transaction;

@Service
public class ParticipantService implements IParticipantService{
	
	@Autowired
	IParticipantDao parDao;
	
	@Autowired
	IDiplomeDao diplDao;
	
	@Autowired
	ITransactionDao transacDao;

	@Override
	public void add(Participant p) {
		
		parDao.save(p);
		
	}

	@Override
	public List<Participant> selectAll() {
		List<Participant> participants = parDao.findAll();
		return participants;
	}

	@Override
	public Participant selectById(int id) {
		
		Participant p  = parDao.findById(id).get();
		
		return p;
	}

	@Override
	public void delete(int id) {
		
		Participant p = parDao.findById(id).get();
		
		List<Transaction> trans = p.getTransactions();
		for(Transaction t:trans) {			
			transacDao.delete(t);
			}
		
		p.setTransactions(null);
		
		List<Diplome> diplomes = p.getDiplomes();
		for(Diplome d:diplomes) {			
			diplDao.delete(d);
			}
		
		p.setDiplomes(null);
		
		List<Formation> fs = p.getFormations();		
		for(Formation f:fs) {			
			f.getParticipants().remove(p);
				
			}

		p.setFormations(null);
		
		
		parDao.deleteById(id);
		
	}
	 

	public List<Participant> chercherParFormationId(int id)
	{
		List<Participant> participants = parDao.findByFormations_id(id); 
		return participants; 
	}
}
