package com.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.RendezVous;

public interface IRendezVousDao extends JpaRepository<RendezVous, Integer> {

	
	public List<RendezVous> findByProspect_id(int id); 
}
