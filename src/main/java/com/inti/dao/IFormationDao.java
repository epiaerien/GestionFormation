package com.inti.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Formateur;
import com.inti.model.Formation;

public interface IFormationDao extends JpaRepository<Formation, Integer> {
	public Set<Formation> findAllByParticipants_id(int id);
	
	public List<Formation> findByFormateur_id(int id);
	
	
}
