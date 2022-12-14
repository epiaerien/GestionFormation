package com.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Participant;

public interface IParticipantDao extends JpaRepository<Participant, Integer>{

	
	public List<Participant> findByFormations_id(int id); 
}
