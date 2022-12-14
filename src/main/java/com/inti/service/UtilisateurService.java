package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.inti.dao.IUtilisateurDao;
import com.inti.model.Utilisateurs;

@Service
public class UtilisateurService implements IUtilisateurService{
	
	@Autowired
	IUtilisateurDao utDao;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	

	@Override
	public void add(Utilisateurs u) {
		
		String pass = u.getPassword();
		
		String encodedPass = encoder.encode(pass);
		
		u.setPassword(encodedPass);
		utDao.save(u);
		
	}
	

	

	@Override
	public List<Utilisateurs> selectAll() {
		List<Utilisateurs> utilisateurs = utDao.findAll();
		return utilisateurs;
	}

	@Override
	public Utilisateurs selectById(int id) {
		
		Utilisateurs u  = utDao.findById(id).get();
		
		return u;
	}

	@Override
	public void delete(int id) {
		
		utDao.deleteById(id);
		
	}

	@Override
	public Utilisateurs findByUsername(String username) {
		
		Utilisateurs ut = utDao.findByUsername(username);
		
		return ut;
	}
	
	

}
