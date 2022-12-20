package com.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Diplome;

public interface IDiplomeDao extends JpaRepository<Diplome, Integer> {
	
	public List<Diplome> findAllByParticipant_id (int idPart);
	
	public List<Diplome> findAllByFormation_id (int idForm);
	
	

}
