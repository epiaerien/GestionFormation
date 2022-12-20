package com.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Utilisateurs;

public interface IUtilisateurDao extends JpaRepository<Utilisateurs, Integer>{

	public Utilisateurs findByUsername(String Username);
	
}
