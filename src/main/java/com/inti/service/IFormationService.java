package com.inti.service;

import java.util.List;
import java.util.Set;

import com.inti.model.Formateur;
import com.inti.model.Formation;

public interface IFormationService {

	void add(Formation form);

	List<Formation> selectAll();

	Formation selectById(int id);

	void delete(int id);
	
	Set<Formation> getByidParticipants(int id);

	public List<Formation> getbyidformateur(int id);

}