package com.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Appel;


public interface IAppelDao extends JpaRepository<Appel, Integer>{
	
	public List<Appel> findByCommercial_id(int id);
	public List<Appel> findByProspect_id(int id);
}
