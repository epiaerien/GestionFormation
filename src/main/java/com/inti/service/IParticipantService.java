package com.inti.service;

import java.util.List;

import com.inti.model.Participant;

public interface IParticipantService {
	public void add(Participant p);
	public List<Participant> selectAll();
	public Participant selectById(int id);
	public void delete(int id);
	public List<Participant> chercherParFormationId(int id); 

}
