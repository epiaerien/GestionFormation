package com.inti.service;

import java.util.List;

import com.inti.model.Formateur;
import com.inti.model.Formation;

public interface IFormateurService {
	public void add(Formateur f);
	public List<Formateur> selectAll();
	public Formateur selectById(int id);
	public void delete(int id);
	public Formateur chercherParFormationId(int id); 
}
