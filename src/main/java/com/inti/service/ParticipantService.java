package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inti.dao.IParticipantDao;
import com.inti.model.Participant;

public class ParticipantService implements IParticipantService{
	
	@Autowired
	IParticipantDao parDao;

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
		
		parDao.deleteById(id);
		
	}
	 

}