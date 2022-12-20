package com.inti.service;

import java.util.List;

import com.inti.model.Utilisateurs;

public interface IUtilisateurService {
	
	public void add(Utilisateurs u);
	public List<Utilisateurs> selectAll();
	public Utilisateurs selectById(int id);
	public void delete(int id);
	public Utilisateurs findByUsername(String username);

}
