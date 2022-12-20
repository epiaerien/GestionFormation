package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.AuthRetour;
import com.inti.model.Utilisateurs;
import com.inti.service.IUtilisateurService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class AuthentificationController {
	
	@Autowired
	IUtilisateurService utService;
	
	@GetMapping("/cnx")
	public AuthRetour cnx()
	{
		return new AuthRetour("Connexion ok");
	}
	
	@GetMapping("/cnx/{username}")
	public Utilisateurs getUser(@PathVariable("username") String username)
	{
		Utilisateurs u = utService.findByUsername(username);
		
		return u;
	}
	

}
